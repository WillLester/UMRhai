package edu.nju.umr.data.orderApproveData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;
import edu.nju.umr.po.order.OrderPO;

public class OrderApproveData extends UnicastRemoteObject implements OrderApproveDSer{

	protected OrderApproveData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<OrderPO> getExamine() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean update(ArrayList<OrderPO> po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public OrderPO getOrder(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
