package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.order.OrderPO;

public interface OrderNewDSer extends Remote{
	public boolean add(OrderPO order) throws RemoteException;
}
