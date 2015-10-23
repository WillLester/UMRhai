package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.orderNewDSer.StockInOrderDSer;
import edu.nju.umr.po.order.StockInPO;

public class StockInOrderData extends UnicastRemoteObject implements StockInOrderDSer{

	protected StockInOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(StockInPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

}
