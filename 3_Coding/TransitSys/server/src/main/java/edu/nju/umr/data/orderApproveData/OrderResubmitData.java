package edu.nju.umr.data.orderApproveData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.order.PaymentPO;

public class OrderResubmitData extends UnicastRemoteObject implements OrderResubmitDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5947380830581319837L;

	public OrderResubmitData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<Object> getOrders(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		PaymentPO pay = new PaymentPO(id, Calendar.getInstance(), "董先生", "12345", Pay.WAGE, 100, null,Calendar.getInstance());
		ArrayList<Object> orders = new ArrayList<Object>();
		orders.add(pay);
		return orders;
	}

}
