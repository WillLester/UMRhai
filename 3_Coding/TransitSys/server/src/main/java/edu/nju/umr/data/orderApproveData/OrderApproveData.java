package edu.nju.umr.data.orderApproveData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.po.order.PaymentPO;
/*
 * 单据审批数据
 */
public class OrderApproveData extends UnicastRemoteObject implements OrderApproveDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3649658232155573648L;
	private MysqlService mysqlSer;

	public OrderApproveData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public ArrayList<OrderPO> getExamine() throws RemoteException {
		// TODO 自动生成的方法存根
		OrderPO order = new OrderPO("12345", Order.EXPRESS, "宝华", Calendar.getInstance(), false);
		ArrayList<OrderPO> orderList = new ArrayList<OrderPO>();
		orderList.add(order);
		return orderList;
	}

	public Result update(boolean isPassed,ArrayList<String> id,Order kind) throws RemoteException {
		// TODO 自动生成的方法存根
		return Result.SUCCESS;
	}

	public Object getOrder(String id,Order kind) throws RemoteException {
		// TODO 自动生成的方法存根
		PaymentPO pay = new PaymentPO(Integer.parseInt(id), Calendar.getInstance(), "董先生", "12345", Pay.WAGE, 100, null,Calendar.getInstance(),"宝华");
		return pay;
	}

}
