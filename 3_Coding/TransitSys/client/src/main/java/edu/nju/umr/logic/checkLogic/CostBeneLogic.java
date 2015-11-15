package edu.nju.umr.logic.checkLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.checkDSer.CostBeneDSer;
import edu.nju.umr.dataService.dataFactory.CostBeneDFacSer;
import edu.nju.umr.logicService.checkLogicSer.CostBeneLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.url.Url;
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
	public ResultMessage getIncome() {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage getPayment() {
		// TODO 自动生成的方法存根
		return null;
	}

	public Result outputExcel(String location, ArrayList<IncomeVO> income,
			ArrayList<PaymentVO> payment) {
		// TODO 自动生成的方法存根
		return Result.SUCCESS;
	}

}
