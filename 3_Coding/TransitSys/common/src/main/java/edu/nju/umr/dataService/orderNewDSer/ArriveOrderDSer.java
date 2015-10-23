package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.order.ArrivePO;

public interface ArriveOrderDSer extends Remote{
	public boolean create(ArrivePO order) throws RemoteException;
}
