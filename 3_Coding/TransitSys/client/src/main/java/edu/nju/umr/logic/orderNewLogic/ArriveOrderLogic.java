package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.dataService.dataFactory.ArriveOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.ArriveOrderDSer;
import edu.nju.umr.logicService.orderNewLogic.ArriveOrderLSer;
import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ArriveVO;

public class ArriveOrderLogic implements ArriveOrderLSer{
	ArriveOrderDFacSer dataFac;
	ArriveOrderDSer arriveData;
	public ArriveOrderLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (ArriveOrderDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			arriveData = dataFac.getArriveOrder();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public boolean create(ArriveVO order) {
		// TODO 自动生成的方法存根
		boolean isSuc = false;
		try {
			isSuc = arriveData.create(new ArrivePO(order.getCenterId(), order.getDate(), order.getId(), order.getStartPlace(), order.getState(),Calendar.getInstance()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return isSuc;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
		ArrayList<String> cities = null;
		try {
			cities = arriveData.getCities();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(true, cities);
	}
	
}
