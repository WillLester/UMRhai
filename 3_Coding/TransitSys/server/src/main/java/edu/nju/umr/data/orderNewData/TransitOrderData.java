package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.orderNewDSer.TransitOrderDSer;
import edu.nju.umr.po.order.TransitPO;

public class TransitOrderData extends UnicastRemoteObject implements TransitOrderDSer{

	protected TransitOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(TransitPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

}
