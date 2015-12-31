package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.OrderCalcuDSer;
import edu.nju.umr.po.CitiesPO;

public class OrderCalcuData extends UnicastRemoteObject implements OrderCalcuDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -936742190169868841L;

	private MysqlService mysqlSer;
	private static OrderCalcuData data = null;
	private OrderCalcuData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static OrderCalcuData getOrderCalcu() throws RemoteException{
		if(data == null){
			data = new OrderCalcuData();
		}
		return data;
	}

	@Override
	public CitiesPO getCitesPO(String city1, String city2)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new CitiesPO(city1, city2, 0));
		try {
			if(result.next()){
				CitiesPO cities = new CitiesPO(result.getString(1), result.getString(2), result.getDouble(3));
				return cities;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
	}

}
