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
	private static ArriveOrderData data = null;
	private ArriveOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static ArriveOrderData getArriveOrder() throws RemoteException{
		if(data == null){
			data = new ArriveOrderData();
		}
		return data;
	}

	public Result create(ArrivePO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
	}
}
