package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.orderNewDSer.OrderNewDSer;
import edu.nju.umr.po.order.OrderPO;

public class OrderNewData extends UnicastRemoteObject implements OrderNewDSer{

	protected OrderNewData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean add(OrderPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

}
