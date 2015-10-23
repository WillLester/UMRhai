package edu.nju.umr.data.orderApproveData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;
import edu.nju.umr.po.order.OrderPO;

public class OrderResubmitData extends UnicastRemoteObject implements OrderResubmitDSer{

	protected OrderResubmitData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<OrderPO> getOrders(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
