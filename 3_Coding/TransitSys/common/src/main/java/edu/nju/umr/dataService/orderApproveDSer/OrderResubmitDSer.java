package edu.nju.umr.dataService.orderApproveDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.order.KindGetter;

public interface OrderResubmitDSer extends Remote{
	public ArrayList<KindGetter> getOrders(String id) throws RemoteException;
}
