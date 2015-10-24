package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.orderNewDSer.ReceiveOrderDSer;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.ReceivePO;

public class ReceiveOrderData extends UnicastRemoteObject implements ReceiveOrderDSer{

	protected ReceiveOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(ReceivePO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public ExpressPO getExpress(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
