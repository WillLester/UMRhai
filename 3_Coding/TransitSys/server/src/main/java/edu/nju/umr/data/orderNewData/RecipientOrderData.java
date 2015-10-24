package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.orderNewDSer.RecipientOrderDSer;
import edu.nju.umr.po.order.RecipientPO;

public class RecipientOrderData extends UnicastRemoteObject implements RecipientOrderDSer{

	protected RecipientOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(RecipientPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<String> getCities() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
