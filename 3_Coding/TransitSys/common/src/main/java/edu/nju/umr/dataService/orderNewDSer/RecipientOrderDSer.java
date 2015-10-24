package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.order.RecipientPO;

public interface RecipientOrderDSer extends Remote{
	public boolean create(RecipientPO order) throws RemoteException;
	public ArrayList<String> getCities() throws RemoteException;
}
