package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.orderNewDSer.StockOutOrderDSer;
import edu.nju.umr.po.order.StockOutPO;

public class StockOutOrderData extends UnicastRemoteObject implements StockOutOrderDSer{

	protected StockOutOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(StockOutPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<String> getCities() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
