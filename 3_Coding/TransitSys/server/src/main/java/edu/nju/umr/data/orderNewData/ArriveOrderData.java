package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.orderNewDSer.ArriveOrderDSer;
import edu.nju.umr.po.order.ArrivePO;

public class ArriveOrderData extends UnicastRemoteObject implements ArriveOrderDSer{

	protected ArriveOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(ArrivePO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

}
