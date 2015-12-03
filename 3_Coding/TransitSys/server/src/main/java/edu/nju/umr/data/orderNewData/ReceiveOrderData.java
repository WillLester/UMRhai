package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.ReceiveOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ExpressPO;

public class ReceiveOrderData extends UnicastRemoteObject implements ReceiveOrderDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5443581465009073248L;
	private MysqlService mysqlSer;
	protected ReceiveOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	@Override
	public Result create(ExpressPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(order);
	}

}
