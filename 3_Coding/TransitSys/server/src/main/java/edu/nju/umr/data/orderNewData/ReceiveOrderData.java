package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import edu.nju.umr.dataService.orderNewDSer.ReceiveOrderDSer;
import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.ReceivePO;

public class ReceiveOrderData extends UnicastRemoteObject implements ReceiveOrderDSer{

	public ReceiveOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(ReceivePO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public ExpressPO getExpress(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		@SuppressWarnings("deprecation")
		Date date = new Date(109, 4, 25,11,24,30);
		ExpressPO express = new ExpressPO("宝华", "香港", "长者", "北京", "16087292054", "10000000000", 1, "大新闻", 10, 10,10, 20, 1000, "12345",date , Express.NORMAL, 100);
		return express;
	}

}
