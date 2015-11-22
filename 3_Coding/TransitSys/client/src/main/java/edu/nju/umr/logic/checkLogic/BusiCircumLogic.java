package edu.nju.umr.logic.checkLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.checkDSer.BusiCircumDSer;
import edu.nju.umr.dataService.dataFactory.StatementSheetDFacSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.checkLogicSer.BusiCircumLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;
import edu.nju.umr.vo.order.PaymentVO;

public class BusiCircumLogic implements BusiCircumLSer{
	StatementSheetDFacSer dataFac;
	BusiCircumDSer statementData;
	UtilityLogic uti;
	ArrayList<IncomePO> incomePOs=null;
	ArrayList<PaymentPO> paymentPOs=null;
	public BusiCircumLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (StatementSheetDFacSer)Naming.lookup(Url.URL);
			statementData = dataFac.getStatement();
			uti=new UtilityLogic();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	//返回收款单list
	public ResultMessage seeIncome(Calendar start, Calendar end) {
		// TODO 自动生成的方法存根
		ArrayList<IncomeVO> incomeList = new ArrayList<IncomeVO>();
		try {
			incomePOs = statementData.findIncome(start, end);
			for(IncomePO po:incomePOs){
				IncomeVO vo = new IncomeVO(po.getDate(), po.getCourier(), po.getCost(), po.getExpress());
				incomeList.add(vo);
			}
		} catch (RemoteException e) {
			return new ResultMessage(Result.NET_INTERRUPT,null);
		} catch (NullPointerException e){
			return new ResultMessage(Result.Data_Not_Found,null);
		}
		
		return new ResultMessage(Result.SUCCESS, incomeList);
	}
	//返回付款单list
	public ResultMessage seePayment(Calendar start, Calendar end){
		ArrayList<PaymentVO> paymentList=new ArrayList<PaymentVO>();
		try {
			paymentPOs=statementData.findPayment(start, end);
			for(PaymentPO po:paymentPOs){
				PaymentVO vo=new PaymentVO(po.getDate(), po.getPayer(), po.getAccount(), po.getKind(), po.getAmount(), po.getRemarks());
				paymentList.add(vo);
			}
		} catch (RemoteException e) {
			return new ResultMessage(Result.NET_INTERRUPT,null);
		} catch(NullPointerException e){
			return new ResultMessage(Result.Data_Not_Found,null);
		}
		
		return new ResultMessage(Result.SUCCESS,paymentList);
		
	}

	public ResultMessage getHall() {
		// TODO 自动生成的方法存根
//		ArrayList<OrgVO> hallList = new ArrayList<OrgVO>();
//		try {
//			ArrayList<OrgPO> halls = statementData.getHall();
//			for(OrgPO hall:halls){
//				CityVO city = new CityVO(hall.getCity().getName(), hall.getCity().getId(),hall.getCity().getProvince());
//				OrgVO vo = new OrgVO(hall.getId(), hall.getName(), hall.getKind(), hall.getLocation(), city);
//				hallList.add(vo);
//			}
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		return new ResultMessage(Result.SUCCESS, hallList);
		return uti.getHall();
	}

	public Result outputExcel(String data[][],String name, String location) {
		// TODO 自动生成的方法存根
		return Result.SUCCESS;
	}

}
