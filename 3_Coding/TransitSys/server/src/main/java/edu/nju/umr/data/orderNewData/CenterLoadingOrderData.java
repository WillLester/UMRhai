package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.CenterLoadingOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.function.GetToday;
/*
 * 中转中心装车单数据
 */
public class CenterLoadingOrderData extends UnicastRemoteObject implements CenterLoadingOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5859251989231665786L;
	private MysqlService mysqlSer;
	private static CenterLoadingOrderData data = null;
	private CenterLoadingOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static CenterLoadingOrderData getCenterLoading() throws RemoteException{
		if(data == null){
			data = new CenterLoadingOrderData();
		}
		return data;
	}

	public Result create(CenterLoadingPO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
		
	}

	@Override
	public int getOrderSize(String partId) throws RemoteException {
		// TODO 自动生成的方法存根
		GetToday get = new CenterLoadingPO(null, partId, null, null, null, null, null, null, null, 0, null);
		ResultSet result = mysqlSer.checkToday(get);
		int count = 0;
		try {
			while(result.next()){
				count++;
			}
			return count;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return -1;
		}
	}

}
