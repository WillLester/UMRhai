package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.TransitOrderDSer;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.order.TransitPO;
/*
 * 中转单数据
 */
public class TransitOrderData extends UnicastRemoteObject implements TransitOrderDSer{
	private MysqlService mysqlSer;
	public TransitOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(TransitPO order) throws RemoteException {
		return mysqlSer.addInfo(order, POKind.TRANSIT);
		
	}

	public ArrayList<String> getCities() throws RemoteException {
		// TODO 自动生成的方法存根
		String city1 = "香港";
		String city2 = "北京";
		ArrayList<String> cities = new ArrayList<String>();
		cities.add(city1);
		cities.add(city2);
		return cities;
	}

}
