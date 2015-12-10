package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
	private static IncomeOrderData data = null;
	private IncomeOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static IncomeOrderData getIncomeOrder() throws RemoteException{
		if(data == null){
			data = new IncomeOrderData();
		}
		return data;
	}

	public Result create(IncomePO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
		
	}

}
