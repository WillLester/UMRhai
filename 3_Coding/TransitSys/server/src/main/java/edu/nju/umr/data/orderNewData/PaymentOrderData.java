package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.orderNewDSer.PaymentOrderDSer;
import edu.nju.umr.po.order.PaymentPO;

public class PaymentOrderData extends UnicastRemoteObject implements PaymentOrderDSer{

	protected PaymentOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(PaymentPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

}