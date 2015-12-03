package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.TransitOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.TransitPO;
/*
 * 中转单数据
 */
public class TransitOrderData extends UnicastRemoteObject implements TransitOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5351880203808666658L;
	private MysqlService mysqlSer;
	public TransitOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public Result create(TransitPO order) throws RemoteException {
		return mysqlSer.addInfo(order);
		
	}

}
