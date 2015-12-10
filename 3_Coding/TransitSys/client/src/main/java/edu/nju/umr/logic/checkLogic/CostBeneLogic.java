package edu.nju.umr.logic.checkLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.checkDSer.CostBeneDSer;
import edu.nju.umr.dataService.dataFactory.CostBeneDFacSer;
import edu.nju.umr.logicService.checkLogicSer.CostBeneLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.vo.CostBeneVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;
import edu.nju.umr.vo.order.PaymentVO;

public class CostBeneLogic implements CostBeneLSer{
	private CostBeneDSer costBeneDSer;
	public CostBeneLogic() {
		// TODO 自动生成的构造函数存根
		try {
			CostBeneDFacSer dataFac = (CostBeneDFacSer) Naming.lookup(Url.URL);
			costBeneDSer = dataFac.getCostBene();
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
	private ResultMessage totalIncome() {
		ArrayList<IncomePO> incomeList=null;
		try {
			incomeList=costBeneDSer.getIncomes();
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		
		double total=0;
		if(incomeList.size()>0){
			for(IncomePO income:incomeList){
				total+=income.getCost();
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
		
		double total=0;
		if(paymentList.size()>0)
		for(PaymentPO payment:paymentList){
			total+=payment.getAmount();
		}
		return new ResultMessage(Result.SUCCESS,total);
	}

	public Result outputExcel(String location, ArrayList<IncomeVO> income,
			ArrayList<PaymentVO> payment) {
		// TODO 自动生成的方法存根
		return Result.SUCCESS;
	}
	
	public ResultMessage getCostBene(){
		ResultMessage income=totalIncome();
		ResultMessage payment=totalPayment();
		if(income.getReInfo()!=Result.SUCCESS||payment.getReInfo()!=Result.SUCCESS){
			return new ResultMessage(Result.NET_INTERRUPT,null);//可能存在隐患！
		}else{
			double in=(double)income.getMessage();
			double pay=(double)payment.getMessage();
			CostBeneVO cb=new CostBeneVO(in,pay,in-pay);
			return new ResultMessage(Result.SUCCESS,cb);
		}
		
		
	}

}
