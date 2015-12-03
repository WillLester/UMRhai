package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.StockOutOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockOutPO;
/*
 * 出库单数据
 */
public class StockOutOrderData extends UnicastRemoteObject implements StockOutOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3477803137644370675L;
	private MysqlService mysqlSer;
	public StockOutOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public Result create(StockOutPO order) throws RemoteException {
		return mysqlSer.addInfo(order);
	}

}
