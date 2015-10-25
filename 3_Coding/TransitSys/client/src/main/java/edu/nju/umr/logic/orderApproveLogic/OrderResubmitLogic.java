package edu.nju.umr.logic.orderApproveLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.dataFactory.OrderResubmitDFacSer;
import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderResubmitLSer;
import edu.nju.umr.vo.ResultMessage;

public class OrderResubmitLogic implements OrderResubmitLSer{
	OrderResubmitDFacSer dataFac;
	OrderResubmitDSer resubmitData;
	public OrderResubmitLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (OrderResubmitDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			resubmitData = dataFac.getOrderResubmit();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public ResultMessage getOrders(String id) {
		// TODO 自动生成的方法存根
		ArrayList<Object> orders = null;
		try {
			orders = resubmitData.getOrders(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(true, orders);
	}

}
