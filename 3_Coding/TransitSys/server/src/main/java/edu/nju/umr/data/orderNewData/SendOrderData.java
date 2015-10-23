package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.orderNewDSer.SendOrderDSer;
import edu.nju.umr.po.order.SendPO;

public class SendOrderData extends UnicastRemoteObject implements SendOrderDSer{

	protected SendOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(SendPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

}
