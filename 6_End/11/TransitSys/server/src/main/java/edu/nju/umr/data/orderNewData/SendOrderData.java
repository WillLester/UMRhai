package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.SendOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.po.order.function.GetToday;
/*
 * 派件单数据
 */
public class SendOrderData extends UnicastRemoteObject implements SendOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5907519790330354429L;
	private MysqlService mysqlSer;
	private static SendOrderData data;
	private SendOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static SendOrderData getSendOrder() throws RemoteException{
		if(data == null){
			data = new SendOrderData();
		}
		return data;
	}

	public Result create(SendPO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
	}

	@Override
	public int getOrderSize(String partId) throws RemoteException {
		// TODO 自动生成的方法存根
		GetToday get = new SendPO(null, null, partId, null, null, null, null);
		ResultSet result = mysqlSer.checkToday(get);
		return OrderCounter.count(result);
	}

}
