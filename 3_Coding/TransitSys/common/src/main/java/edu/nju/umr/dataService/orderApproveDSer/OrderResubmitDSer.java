package edu.nju.umr.dataService.orderApproveDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface OrderResubmitDSer extends Remote{
	public ArrayList<Object> getOrders(String id) throws RemoteException;
}
