package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.order.SendPO;

public interface SendOrderDSer extends Remote{
	public boolean create(SendPO order) throws RemoteException;
	public ArrayList<String> getCouriers() throws RemoteException;
}
