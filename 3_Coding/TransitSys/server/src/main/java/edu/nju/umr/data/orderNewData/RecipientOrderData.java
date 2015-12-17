package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.OrderCounter;
import edu.nju.umr.dataService.orderNewDSer.RecipientOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.po.order.function.GetToday;
/*
 * 接收单数据
 */
public class RecipientOrderData extends UnicastRemoteObject implements RecipientOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 134682087211527556L;
	private MysqlService mysqlSer;
	private static RecipientOrderData data = null;
	private RecipientOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static RecipientOrderData getRecipientOrder() throws RemoteException{
		if(data == null){
			data = new RecipientOrderData();
		}
		return data;
	}

	public Result create(RecipientPO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
	}

	@Override
	public int getOrderSize(String partId) throws RemoteException {
		// TODO 自动生成的方法存根
		GetToday get = new RecipientPO(null, partId, null, null, null, null, null, null);
		ResultSet result = mysqlSer.checkToday(get);
		return OrderCounter.count(result);
	}

}
