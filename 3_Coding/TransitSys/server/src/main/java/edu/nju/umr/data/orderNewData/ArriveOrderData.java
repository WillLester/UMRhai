package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.ArriveOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ArrivePO;
/*
 * 到达单数据
 */
public class ArriveOrderData extends UnicastRemoteObject implements ArriveOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8104606631614005305L;
	private MysqlService mysqlSer;
	public ArriveOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public Result create(ArrivePO order) throws RemoteException {
		return mysqlSer.addInfo(order);
	}

//	public ArrayList<String> getCities() throws RemoteException {
//		String city1 = "香港";
//		String city2 = "北京";
//		ArrayList<String> cities = new ArrayList<String>();
//		cities.add(city1);
//		cities.add(city2);
//		return cities;
//	}

}
