package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.PaymentOrderDSer;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.order.PaymentPO;
/*
 * 付款单数据
 */
public class PaymentOrderData extends UnicastRemoteObject implements PaymentOrderDSer{
	private MysqlService mysqlSer;
	public PaymentOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(PaymentPO order) throws RemoteException {
		return mysqlSer.addInfo(order, POKind.PAYMENT);
		
	}

}
