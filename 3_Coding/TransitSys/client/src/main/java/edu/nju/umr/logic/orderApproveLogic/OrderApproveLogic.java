package edu.nju.umr.logic.orderApproveLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.OrderApproveDFacSer;
import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;
import edu.nju.umr.logic.orderNewLogic.UpdateTranStateLogic;
import edu.nju.umr.logic.utilityLogic.CheckUtility;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderApproveLSer;
import edu.nju.umr.logicService.orderNewLogic.UpdateTranStateLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.po.order.TransitPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ArriveVO;
import edu.nju.umr.vo.order.CenterLoadingVO;
import edu.nju.umr.vo.order.ExpressVO;
import edu.nju.umr.vo.order.HallLoadingVO;
import edu.nju.umr.vo.order.IncomeVO;
import edu.nju.umr.vo.order.OrderVO;
import edu.nju.umr.vo.order.PaymentVO;
import edu.nju.umr.vo.order.RecipientVO;
import edu.nju.umr.vo.order.SendVO;
import edu.nju.umr.vo.order.StockInVO;
import edu.nju.umr.vo.order.StockOutVO;
import edu.nju.umr.vo.order.TransitVO;


public class OrderApproveLogic implements OrderApproveLSer{
	private OrderApproveDFacSer dataFac;
	private OrderApproveDSer approveData;
	private ArrayList<OrderPO> orderList=new ArrayList<OrderPO>();
	private DiaryUpdateLSer diarySer;
	private OrderUpdate update;
	private UpdateTranStateLSer state;
	public OrderApproveLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (OrderApproveDFacSer)Naming.lookup(Url.URL);
			approveData = dataFac.getOrderApprove();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		diarySer = new DiaryUpdateLogic();
		update = new OrderUpdate();
		state = new UpdateTranStateLogic();
	}
	public ResultMessage askExamine() {
		
		ArrayList<OrderVO> orders = new ArrayList<OrderVO>();
		try {
			 orderList= approveData.getExamine();
			for(OrderPO order:orderList){
				OrderVO vo = new OrderVO(order.getId(), order.getKind(), order.getOperator(), order.getTime());
				orders.add(vo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		return new ResultMessage(Result.SUCCESS, orders);
	}

	public Result examine(boolean approve, ArrayList<Integer> indexs,String name) {
		//每次更新的结果
		ArrayList<Result> results=new ArrayList<Result>();
		for(int i=0;i<indexs.size();i++){
			OrderPO order=orderList.get(indexs.get(i));
			Result re = updateTransitInfo(order.getId(), order.getKind());
			if(re != Result.SUCCESS){
				return re;
			}
			ArrayList<String> ids=new ArrayList<String>();
//			for(int j=0;j<indexs.size();j++){
//				OrderPO sameKind=orderList.get(indexs.get(j));
//				if(sameKind.getKind().equals(order.getKind())){
//					ids.add(sameKind.getId());
//					indexs.remove(j);
//					j--;
//				}					
//			}
			ids.add(order.getId());
			try {
				results.add(approveData.update(approve, ids, order.getKind()));
				
				if(approve==false&&order.getKind().equals(Order.HALLLOADING)){
					ResultMessage message = chooseOrder(ids.get(0),order.getKind());
					Result result=message.getReInfo();
					if(!result.equals(Result.SUCCESS)){
						return result;
					}
					HallLoadingVO vo=(HallLoadingVO)message.getMessage();
					for(String express:vo.getExpress()){
						result=state.updateExpressState(express, vo.getHallId());
						if(!result.equals(Result.SUCCESS)){
							return result;
						}
					}
				}
				
				if(order.getKind().equals(Order.ARRIVE)){
					ResultMessage message = chooseOrder(ids.get(0),order.getKind());
					Result result=message.getReInfo();
					if(!result.equals(Result.SUCCESS)){
						return result;
					}
					ArrivePO ap=(ArrivePO)message.getMessage();
					String id=ap.getId();
					if(id.length()==19){
						message=chooseOrder(id,Order.HALLLOADING);
						result=message.getReInfo();
						if(!result.equals(Result.SUCCESS)){
							return result;
						}
						HallLoadingPO hp=(HallLoadingPO)message.getMessage();
						if(approve){
							for(String express:hp.getExpress()){
								result=state.updateExpressState(express,ap.getCenterId());
								if(!result.equals(Result.SUCCESS)){
									return result;
								}
							}
						}else{
							result=state.updateHallLoadingState(id, false);
							if(!result.equals(Result.SUCCESS)){
								return result;
							}
						}
					}else{
						message=chooseOrder(id,Order.TRANSIT);
						result=message.getReInfo();
						if(!result.equals(Result.SUCCESS)){
							return result;
						}
						TransitPO tp=(TransitPO)message.getMessage();
						if(approve){
							for(String express:tp.getExpress()){
								result=state.updateExpressState(express,ap.getCenterId());
								if(!result.equals(Result.SUCCESS)){
									return result;
								}
							}
						}else{
							result=state.updateTransitState(id, false);
							if(!result.equals(Result.SUCCESS)){
								return result;
							}
						}
					}
				}
				
				if(order.getKind().equals(Order.STOCKIN)){
					ResultMessage message=chooseOrder(order.getId(),Order.STOCKIN);
					Result result=message.getReInfo();
					if(!result.equals(Result.SUCCESS)){
						return result;
					}
					StockInPO sp=(StockInPO)message.getMessage();
					if(approve){
						result=state.updateExpressState(sp.getExpressId(), sp.getStockId()+"*");
						if(!result.equals(Result.SUCCESS)){
							return result;
						}
					}else{
						result=state.updateExpressState(sp.getExpressId(), sp.getStockId());
						if(!result.equals(Result.SUCCESS)){
							return result;
						}
					}
				}
				
				if(order.getKind().equals(Order.TRANSIT)&&(!approve)){
					ResultMessage message=chooseOrder(order.getId(),Order.TRANSIT);
					Result result=message.getReInfo();
					if(!result.equals(Result.SUCCESS))
					{
						return result;
					}
					TransitPO tp=(TransitPO)message.getMessage();
					for(String express:tp.getExpress()){
						result=state.updateExpressState(express,tp.getStartOrgId()+"*");
						if(!result.equals(Result.SUCCESS))
						{
							return result;
						}
					}
				}
			} catch (RemoteException e){
				e.printStackTrace();
				return Result.NET_INTERRUPT;
			}
		}
		for(Result isSuc:results){
			if(!isSuc.equals(Result.SUCCESS))
				return Result.DATA_NOT_FOUND;
		}
		
		return diarySer.addDiary("审批了单据", name);
	}

	public ResultMessage chooseOrder(String id,Order kind) {
		switch(kind){
		case ARRIVE:
			ArriveVO arrive=null;
			Result arriveSuc=Result.DATA_NOT_FOUND;
			try {
				ArrivePO Arrivepo=(ArrivePO)approveData.getOrder(id, kind);
				if(Arrivepo!=null)
					arriveSuc=Result.SUCCESS;
				arrive=VPFactory.toArriveVO(Arrivepo);
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
			return new ResultMessage(arriveSuc,arrive);
		
		case CENTERLOADING:
			CenterLoadingVO centerLoad=null;
			Result centerLoadSuc=Result.DATA_NOT_FOUND;
			try {
				CenterLoadingPO ctpo=(CenterLoadingPO)approveData.getOrder(id, kind);
				if(ctpo!=null)
					centerLoadSuc=Result.SUCCESS;
				centerLoad=VPFactory.toCenterLoadVO(ctpo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
			return new ResultMessage(centerLoadSuc,centerLoad);
			
		case EXPRESS:
			ExpressVO ev=null;
			Result expressSuc=Result.DATA_NOT_FOUND;
			try {
				ExpressPO ep=(ExpressPO)approveData.getOrder(id, kind);	
				ev=VPFactory.toExpressVO(ep);
				if(ep!=null)
					expressSuc=Result.SUCCESS;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
			return new ResultMessage(expressSuc,ev);
			
		case HALLLOADING:
			HallLoadingVO hv=null;
			Result hallSuc=Result.DATA_NOT_FOUND;
			try {
				HallLoadingPO hp=(HallLoadingPO)approveData.getOrder(id, kind);
				hv=VPFactory.toHallLoadingVO(hp);
				if(hp!=null)
					hallSuc=Result.SUCCESS;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
			return new ResultMessage(hallSuc,hv);
			
		case INCOME:
			IncomeVO iv=null;
			Result iSuc=Result.DATA_NOT_FOUND;
			try {
				IncomePO ip=(IncomePO)approveData.getOrder(id, kind);
				iv=VPFactory.toIncomeVO(ip);
				if(iv!=null)
				{
					iSuc=Result.SUCCESS;
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
			return new ResultMessage(iSuc,iv);
			
		case PAYMENT:
			PaymentVO pv=null;
			Result pSuc=Result.DATA_NOT_FOUND;
			try {
				PaymentPO pp=(PaymentPO)approveData.getOrder(id, kind);
				pv=VPFactory.toPaymentVO(pp);
				if(pp!=null)
					pSuc=Result.SUCCESS;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
			return new ResultMessage(pSuc,pv);
			
		case RECIPIENT:
			RecipientVO recipv=null;
			Result recipSuc=Result.DATA_NOT_FOUND;
			try {
				RecipientPO recipp=(RecipientPO)approveData.getOrder(id, kind);
				recipv=VPFactory.toRecipientVO(recipp);
				if(recipp!=null)
					recipSuc=Result.SUCCESS;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
			return new ResultMessage(recipSuc,recipv);
			
		case SEND:
			SendVO sendv=null;
			Result sendSuc=Result.DATA_NOT_FOUND;
			try {
				SendPO sendp=(SendPO)approveData.getOrder(id, kind);
				sendv=VPFactory.toSendVO(sendp);
				if(sendp!=null)
					sendSuc=Result.SUCCESS;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
			return new ResultMessage(sendSuc,sendv);
			
		case STOCKIN:
			StockInVO stov=null;
			Result stoSuc=Result.DATA_NOT_FOUND;
			try {
				StockInPO stop=(StockInPO)approveData.getOrder(id, kind);
				stov=VPFactory.toStockInVO(stop);
				if(stop!=null)
					stoSuc=Result.SUCCESS;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
			return new ResultMessage(stoSuc,stov);
			
		case STOCKOUT:
			StockOutVO outv=null;
			Result outSuc=Result.DATA_NOT_FOUND;
			try {
				StockOutPO outp=(StockOutPO)approveData.getOrder(id, kind);
				outv=VPFactory.toStockOutVO(outp);
				if(outp!=null)
					outSuc=Result.SUCCESS;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
			return new ResultMessage(outSuc,outv);
			
		case TRANSIT:
			TransitVO tv=null;
			Result tSuc=Result.DATA_NOT_FOUND;
			try {
				TransitPO tp=(TransitPO)approveData.getOrder(id, kind);
				tv=VPFactory.toTransitVO(tp);
				if(tp!=null)
					tSuc=Result.SUCCESS;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
			return new ResultMessage(tSuc,tv);
			
		}
		return null;
	}
	private Result updateTransitInfo(String id,Order kind){
		ResultMessage message = null;
		message = chooseOrder(id, kind);
		
		if(CheckUtility.isSuc(message.getReInfo())){
			update.updateOrder(message, kind, approveData);
		} else {
			return message.getReInfo();
		}
		return Result.SUCCESS;
	}
}
