package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.IncomeOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.IncomePO;
/*
 * 收款单数据
 */
public class IncomeOrderData extends UnicastRemoteObject implements IncomeOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1037020771318795325L;
	private MysqlService mysqlSer;
	public IncomeOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public Result create(IncomePO order) throws RemoteException {
		return mysqlSer.addInfo(order);
		
	}

	public ArrayList<String> getCouriers(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		String courier1 = "宝华";
		String courier2 = "华莱士";
		ArrayList<String> couriers = new ArrayList<String>();
		couriers.add(courier1);
		couriers.add(courier2);
		return couriers;
	}

}
