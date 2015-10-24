package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.orderNewDSer.CenterLoadingOrderDSer;
import edu.nju.umr.po.order.CenterLoadingPO;

public class CenterLoadingOrderData extends UnicastRemoteObject implements CenterLoadingOrderDSer{

	protected CenterLoadingOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(CenterLoadingPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<String> getHalls() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
