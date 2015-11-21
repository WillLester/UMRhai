package edu.nju.umr.data.orderApproveData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.order.PaymentPO;
/*
 * 订单重提交
 */
public class OrderResubmitData extends UnicastRemoteObject implements OrderResubmitDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5947380830581319837L;
	MysqlService mysqlSer;

	public OrderResubmitData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public ArrayList<Object> getOrders(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		PaymentPO pay = new PaymentPO(Integer.parseInt(id), Calendar.getInstance(), "董先生", "12345", Pay.WAGE, 100, null,Calendar.getInstance(),"宝华");
		ArrayList<Object> orders = new ArrayList<Object>();
		orders.add(pay);
		return orders;
	}

}
