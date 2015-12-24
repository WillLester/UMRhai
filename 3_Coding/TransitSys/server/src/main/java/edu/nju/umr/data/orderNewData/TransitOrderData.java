package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.OrderCounter;
import edu.nju.umr.dataService.orderNewDSer.TransitOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.TransitPO;
import edu.nju.umr.po.order.function.GetToday;
/*
 * 中转单数据
 */
public class TransitOrderData extends UnicastRemoteObject implements TransitOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5351880203808666658L;
	private MysqlService mysqlSer;
	private static TransitOrderData data = null;
	private TransitOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static TransitOrderData getTransitOrder() throws RemoteException{
		if(data == null){
			data = new TransitOrderData();
		}
		return data;
	}

	public Result create(TransitPO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
		
	}

	@Override
	public int getOrderSize(String partId) throws RemoteException {
		// TODO 自动生成的方法存根
		GetToday get = new TransitPO(partId, null, null, null, null, null, null, null, null, null, 0, null,null,false,null);
		ResultSet result = mysqlSer.checkToday(get);
		return OrderCounter.count(result);
	}

}
