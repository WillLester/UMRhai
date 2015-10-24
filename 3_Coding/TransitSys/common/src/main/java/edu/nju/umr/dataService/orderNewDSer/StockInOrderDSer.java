package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.order.StockInPO;

public interface StockInOrderDSer extends Remote{
	public boolean create(StockInPO order) throws RemoteException;
	public ArrayList<String> getCities() throws RemoteException;
}
