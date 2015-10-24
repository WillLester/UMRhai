package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.order.IncomePO;

public interface IncomeOrderDSer extends Remote{
	public boolean create(IncomePO order) throws RemoteException;
	public ArrayList<String> getCouriers(String id) throws RemoteException;
}
