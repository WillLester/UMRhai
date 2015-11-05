package edu.nju.umr.data.orderApproveData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.po.order.PaymentPO;

public class OrderResubmitData extends UnicastRemoteObject implements OrderResubmitDSer{

	public OrderResubmitData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<Object> getOrders(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		Date date = new Date(109, 4, 25,11,24,30);
		PaymentPO pay = new PaymentPO(id, date, "董先生", "12345", Pay.WAGE, 100, null,Calendar.getInstance());
		ArrayList<Object> orders = new ArrayList<Object>();
		orders.add(pay);
		return orders;
	}

}
