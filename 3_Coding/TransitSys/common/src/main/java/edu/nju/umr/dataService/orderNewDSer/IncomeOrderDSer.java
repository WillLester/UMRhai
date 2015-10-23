package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.order.IncomePO;

public interface IncomeOrderDSer extends Remote{
	public boolean create(IncomePO order) throws RemoteException;
}
