package edu.nju.umr.dataService.orderApproveDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.order.OrderOper;

public interface OrderResubmitDSer extends Remote{
	public ArrayList<OrderOper> getOrders(String id) throws RemoteException;
}
