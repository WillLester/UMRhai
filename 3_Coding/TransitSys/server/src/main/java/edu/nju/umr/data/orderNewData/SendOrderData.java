package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.SendOrderDSer;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.SendPO;
/*
 * 派件单数据
 */
public class SendOrderData extends UnicastRemoteObject implements SendOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5907519790330354429L;
	private MysqlService mysqlSer;
	public SendOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public Result create(SendPO order) throws RemoteException {
		return mysqlSer.addInfo(order, POKind.SEND);
	}

	public ArrayList<String> getCouriers() throws RemoteException {
		// TODO 自动生成的方法存根
		String courier1 = "宝华";
		String courier2 = "华莱士";
		ArrayList<String> couriers = new ArrayList<String>();
		couriers.add(courier1);
		couriers.add(courier2);
		return couriers;
	}

}
