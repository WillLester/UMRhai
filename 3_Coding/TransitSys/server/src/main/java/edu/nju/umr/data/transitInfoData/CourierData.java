package edu.nju.umr.data.transitInfoData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.transitInfoDSer.CourierDSer;
import edu.nju.umr.po.order.ExpressPO;

public class CourierData extends UnicastRemoteObject implements CourierDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -635682282196387242L;

	public CourierData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ExpressPO find(String barcode) throws RemoteException {
		// TODO 自动生成的方法存根
		ExpressPO express = null;
		return express;
	}

}
