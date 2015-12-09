package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.SendOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.SendPO;
/*
 * 派件单数据
 */
public class SendOrderData extends UnicastRemoteObject implements SendOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5907519790330354429L;
	private MysqlService mysqlSer;
	public SendOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}

	public Result create(SendPO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
	}

}
