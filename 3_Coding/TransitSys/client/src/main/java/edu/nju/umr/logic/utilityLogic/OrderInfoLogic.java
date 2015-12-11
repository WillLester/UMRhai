package edu.nju.umr.logic.utilityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.OrderInfoDFacSer;
import edu.nju.umr.dataService.utilityDSer.OrderInfoDSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;

public class OrderInfoLogic implements OrderInfoLSer{
	private OrderInfoDFacSer dataFac;
	private OrderInfoDSer dataSer;
	
	public OrderInfoLogic() {
		// TODO 自动生成的构造函数存根
		try {
			dataFac = (OrderInfoDFacSer) Naming.lookup(Url.URL);
			dataSer = dataFac.getOrderInfo();
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public boolean isTransitValid(String id){
		try {
			return dataSer.isTransitValid(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
	
	@Override
	public boolean isExpressValid(String id){
		try {
			return dataSer.isExpressValid(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}

	@Override
	public boolean isCenterLoadValid(String id){
		try {
			return dataSer.isCenterLoadValid(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
}
