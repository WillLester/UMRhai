package edu.nju.umr.logic.orderApproveLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.utility.AccountUpdateDFacSer;
import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;
import edu.nju.umr.dataService.utilityDSer.AccountUpdateDSer;
import edu.nju.umr.logic.orderNewLogic.UpdateTransitInfoLogic;
import edu.nju.umr.logic.utilityLogic.OrderInfoLogic;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ArriveVO;
import edu.nju.umr.vo.order.CenterLoadingVO;
import edu.nju.umr.vo.order.ExpressVO;
import edu.nju.umr.vo.order.HallLoadingVO;
import edu.nju.umr.vo.order.IncomeVO;
import edu.nju.umr.vo.order.PaymentVO;
import edu.nju.umr.vo.order.RecipientVO;
import edu.nju.umr.vo.order.SendVO;
import edu.nju.umr.vo.order.TransitVO;

class OrderUpdate {
	private UpdateTransitInfoLogic infoLogic;
	private OrderInfoLSer orderInfo;
	private OrderApproveDSer approveData = null;
	private AccountUpdateDFacSer accountFac;
	private AccountUpdateDSer accountData;
	public OrderUpdate() {
		// TODO 自动生成的构造函数存根
		infoLogic = new UpdateTransitInfoLogic();
		orderInfo = new OrderInfoLogic();
		try {
			accountFac = (AccountUpdateDFacSer) Naming.lookup(Url.URL);
			accountData = accountFac.getAccountUp();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public Result updateOrder(ResultMessage message,Order kind,OrderApproveDSer approveData){
		List<String> list;
		String org;
		this.approveData = approveData;
		switch(kind){
		case ARRIVE:
			ArriveVO voA = (ArriveVO) message.getMessage();
			org = getOrg(voA.getUserId());
			if(org == null){
				return Result.DATA_NOT_FOUND;
			}
			list = getTransitExp(voA.getId());
			if(list == null){
				list = getHallLoadExp(voA.getId());
			} 
			for(String express:list){
				infoLogic.update(express, 
						DateFormat.TIME.format(Calendar.getInstance().getTime())+" "+org+" 已收入");
			}
			break;
		case CENTERLOADING:
			CenterLoadingVO voC = (CenterLoadingVO) message.getMessage();
			org = getOrg(voC.getUserId());
			if(org == null){
				return Result.DATA_NOT_FOUND;
			}
			for(String express:voC.getExpress()){
				infoLogic.update(express, DateFormat.TIME.format(Calendar.getInstance().getTime())
						+" " +org+" 已发出 下一站 "+voC.getTarget());
			}
			break;
		case EXPRESS:
			ExpressVO voE = (ExpressVO) message.getMessage();
			org = getOrg(voE.getUserId());
			if(org == null){
				return Result.DATA_NOT_FOUND;
			}
			infoLogic.addInfo(voE.getId(), DateFormat.TIME.format(Calendar.getInstance().getTime())+" " +org+"快递员 已收件");
			break;
		case HALLLOADING:
			HallLoadingVO voH = (HallLoadingVO) message.getMessage();
			org = getOrg(voH.getUserId());
			if(org == null){
				return Result.DATA_NOT_FOUND;
			}
			for(String express:voH.getExpress()){
				infoLogic.update(express,DateFormat.TIME.format(Calendar.getInstance().getTime())
					+" "+org+" 已发出 下一站 "+voH.getArriveLoc());
			}
			break;
		case INCOME:
			IncomeVO voI = (IncomeVO) message.getMessage();
			try {
				accountData.income(voI.getAccount(), voI.getCost());
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				return Result.NET_INTERRUPT;
			}
			break;
		case PAYMENT:
			PaymentVO voP = (PaymentVO) message.getMessage();
			try {
				accountData.pay(voP.getAccount(), voP.getAmount());
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				return Result.NET_INTERRUPT;
			}
			break;
		case RECIPIENT:
			RecipientVO voR = (RecipientVO) message.getMessage();
			org = getOrg(voR.getUserId());
			if(org == null){
				return Result.DATA_NOT_FOUND;
			}
			list = getTransitExp(voR.getTransitId());
			if(list == null){
				return Result.DATA_NOT_FOUND;
			}
			for(String exp:list){
				infoLogic.update(exp, DateFormat.TIME.format(Calendar.getInstance().getTime()
						+" "+org+" 已收入"));
			}
			break;
		case SEND:
			SendVO voS = (SendVO) message.getMessage();
			org = getOrg(voS.getUserId());
			if(org == null){
				return Result.DATA_NOT_FOUND;
			}
			infoLogic.update(voS.getExpressId(), DateFormat.TIME.format(Calendar.getInstance().getTime())
					+" "+org+"派件员 "+voS.getCourier()+"正在派件");
			break;
		case TRANSIT:
			TransitVO voT = (TransitVO) message.getMessage();
			org = getOrg(voT.getUserId());
			if(org == null){
				return Result.DATA_NOT_FOUND;
			}
			for(String express:voT.getExpress()){
				infoLogic.update(express,DateFormat.TIME.format(Calendar.getInstance().getTime())
						+" "+org+" 已发出 下一站 "+voT.getArrivePlace());
			}
			break;
		default:
			return Result.PO_KIND_ERROR;
		}
		return Result.SUCCESS;
	}
	private String getOrg(String userId){
		UserPO user;
		try {
			user = approveData.getUser(userId);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return user.getOrg();
	}
	
	private List<String> getTransitExp(String id){
		return orderInfo.getTransitExp(id);
	}
	
	private List<String> getHallLoadExp(String id){
		return orderInfo.getHallLoadExp(id);
	}
}
