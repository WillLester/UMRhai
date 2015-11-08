package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.ExpressOrderDSer;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.order.ExpressPO;
/*
 * 快递单数据
 */
public class ExpressOrderData extends UnicastRemoteObject implements ExpressOrderDSer{
	private MysqlService mysqlSer;
	public ExpressOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(ExpressPO order) throws RemoteException {
		return mysqlSer.addInfo(order,POKind.EXPRESS);
	}

}
