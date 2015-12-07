package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.ExpressOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ExpressPO;
/*
 * 快递单数据
 */
public class ExpressOrderData extends UnicastRemoteObject implements ExpressOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5500240540825186850L;
	private MysqlService mysqlSer;
	public ExpressOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}

	public Result create(ExpressPO order) throws RemoteException {
		return mysqlSer.addInfo(order);
	}

}
