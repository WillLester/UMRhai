package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.orderNewDSer.ReceiveOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ExpressPO;

public class ReceiveOrderData extends UnicastRemoteObject implements ReceiveOrderDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5443581465009073248L;

	protected ReceiveOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public Result create(ExpressPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ExpressPO getExpress(String barcode) {
		// TODO 自动生成的方法存根
		return null;
	}

}
