package edu.nju.umr.dataService.orderApproveDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.order.OrderPO;

public interface OrderResubmitDSer extends Remote{
	public ArrayList<OrderPO> getOrders(String id) throws RemoteException;
}
