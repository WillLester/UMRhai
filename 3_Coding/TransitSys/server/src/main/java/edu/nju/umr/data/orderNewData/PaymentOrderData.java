package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.OrderCounter;
import edu.nju.umr.dataService.orderNewDSer.PaymentOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.po.order.function.GetToday;
/*
 * 付款单数据
 */
public class PaymentOrderData extends UnicastRemoteObject implements PaymentOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9162964323292140428L;
	private MysqlService mysqlSer;
	private static PaymentOrderData data = null;
	private PaymentOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static PaymentOrderData getPaymentOrder() throws RemoteException{
		if(data == null){
			data = new PaymentOrderData();
		}
		return data;
	}

	public Result create(PaymentPO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
		
	}

	@Override
	public int getOrderSize(String partId) throws RemoteException {
		// TODO 自动生成的方法存根
		GetToday get = new PaymentPO(partId, null, null, null, null, null, null, null, null, null);
		ResultSet result = mysqlSer.checkToday(get);
		return OrderCounter.count(result);
	}

}
