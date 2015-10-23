package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.order.TransitPO;

public interface TransitOrderDSer extends Remote{
	public boolean create(TransitPO order) throws RemoteException;
}
