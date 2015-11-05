package edu.nju.umr.data.orderApproveData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.po.order.PaymentPO;

public class OrderApproveData extends UnicastRemoteObject implements OrderApproveDSer{

	public OrderApproveData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<OrderPO> getExamine() throws RemoteException {
		// TODO 自动生成的方法存根
		@SuppressWarnings("deprecation")
		Date date = new Date(109, 4, 25,11,24,30);
		OrderPO order = new OrderPO("12345", Order.EXPRESS, "宝华", date, false);
		ArrayList<OrderPO> orderList = new ArrayList<OrderPO>();
		orderList.add(order);
		return orderList;
	}

	public boolean update(boolean isPassed,ArrayList<String> id) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public Object getOrder(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		@SuppressWarnings("deprecation")
		Date date = new Date(109, 4, 25,11,24,30);
		PaymentPO pay = new PaymentPO(id, date, "董先生", "12345", Pay.WAGE, 100, null,Calendar.getInstance());
		return pay;
	}

}
