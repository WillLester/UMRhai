package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;
import edu.nju.umr.po.order.HallLoadingPO;

public class HallLoadingOrderData extends UnicastRemoteObject implements HallLoadingOrderDSer{

	protected HallLoadingOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(HallLoadingPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<String> getOrgs() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<String> getVans() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
