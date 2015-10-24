package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.orderNewDSer.IncomeOrderDSer;
import edu.nju.umr.po.order.IncomePO;

public class IncomeOrderData extends UnicastRemoteObject implements IncomeOrderDSer{

	protected IncomeOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(IncomePO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<String> getCouriers(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
