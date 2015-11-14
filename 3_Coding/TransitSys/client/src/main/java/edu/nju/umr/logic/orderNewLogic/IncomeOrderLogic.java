package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.dataFactory.IncomeOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.IncomeOrderDSer;
import edu.nju.umr.logicService.orderNewLogic.IncomeOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public class IncomeOrderLogic implements IncomeOrderLSer{
	IncomeOrderDFacSer dataFac;
	IncomeOrderDSer incomeData;
	public IncomeOrderLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (IncomeOrderDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			incomeData = dataFac.getIncomeOrder();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public Result create(IncomeVO order) {
		// TODO 自动生成的方法存根
		boolean isSuc = false;
//		try {
//			isSuc = incomeData.create(new IncomePO(order.getDate(), order.getCourier(), order.getCost(), order.getExpress(), order.getId()));
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		return Result.SUCCESS;
	}

	public ResultMessage getCouriers(String id) {
		// TODO 自动生成的方法存根
		ArrayList<String> couriers = null;
		try {
			couriers = incomeData.getCouriers(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(Result.SUCCESS, couriers);
	}

}
