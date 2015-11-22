package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.ArriveOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.ArriveOrderDSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.orderNewLogic.ArriveOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ArriveVO;

public class ArriveOrderLogic implements ArriveOrderLSer{
	ArriveOrderDFacSer dataFac;
	ArriveOrderDSer arriveData;
	UtilityLogic uti;
	public ArriveOrderLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (ArriveOrderDFacSer)Naming.lookup(Url.URL);
			arriveData = dataFac.getArriveOrder();
			uti=new UtilityLogic();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public Result create(ArriveVO order) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc = arriveData.create(new ArrivePO(order.getCenterId(), order.getDate(), "", order.getStartPlace(), order.getState(),Calendar.getInstance(),order.getOpName()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return isSuc;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
//		ArrayList<String> cities = null;
//		try {
//			cities = arriveData.getCities();
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		return new ResultMessage(Result.SUCCESS, cities);
		return uti.getCities();
	}
	
}
