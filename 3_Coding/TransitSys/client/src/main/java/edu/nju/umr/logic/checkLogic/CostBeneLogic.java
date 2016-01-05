package edu.nju.umr.logic.checkLogic;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.checkDSer.CostBeneDSer;
import edu.nju.umr.dataService.dataFactory.check.CostBeneDFacSer;
import edu.nju.umr.logicService.checkLogicSer.CostBeneLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.vo.CostBeneVO;
import edu.nju.umr.vo.ResultMessage;

public class CostBeneLogic implements CostBeneLSer{
	private CostBeneDFacSer dataFac;
	private CostBeneDSer costBeneDSer;
	public CostBeneLogic() throws RemoteException {
		// TODO 自动生成的构造函数存根
		try {
			dataFac = (CostBeneDFacSer) Naming.lookup(Url.URL);
			costBeneDSer = dataFac.getCostBene();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
//		catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		} 
		catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	private ResultMessage totalIncome() {
		ArrayList<IncomePO> incomeList=null;
		try {
			incomeList=costBeneDSer.getIncomes();
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		
		BigDecimal total= new BigDecimal(0);
		if(incomeList.size()>0){
			for(IncomePO income:incomeList){
				total = total.add(income.getCost());
			}
		}
		return new ResultMessage(Result.SUCCESS,total);
	}

	private ResultMessage totalPayment() {
		ArrayList<PaymentPO> paymentList=null;
		try {
			paymentList=costBeneDSer.getPayments();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		
		BigDecimal total = new BigDecimal(0);
		if(paymentList.size()>0)
		for(PaymentPO payment:paymentList){
			total = total.add(payment.getAmount());
		}
		return new ResultMessage(Result.SUCCESS,total);
	}
	
	public ResultMessage getCostBene(){
		ResultMessage income=totalIncome();
		ResultMessage payment=totalPayment();
		if(income.getReInfo()!=Result.SUCCESS||payment.getReInfo()!=Result.SUCCESS){
			return new ResultMessage(Result.NET_INTERRUPT,null);//可能存在隐患！
		}else{
			BigDecimal in=(BigDecimal)income.getMessage();
			BigDecimal pay=(BigDecimal)payment.getMessage();
			CostBeneVO cb=new CostBeneVO(in,pay,in.subtract(pay));
			return new ResultMessage(Result.SUCCESS,cb);
		}
		
		
	}

}
