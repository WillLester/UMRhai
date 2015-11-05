package edu.nju.umr.data.transitInfoData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import edu.nju.umr.dataService.transitInfoDSer.CourierDSer;
import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.order.ExpressPO;

public class CourierData extends UnicastRemoteObject implements CourierDSer{

	public CourierData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ExpressPO find(String barcode) throws RemoteException {
		// TODO 自动生成的方法存根
		@SuppressWarnings("deprecation")
		Date date = new Date(109, 4, 25,11,24,30);
		ExpressPO express = null;
		return express;
	}

}
