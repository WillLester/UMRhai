package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.order.ExpressPO;

public interface ExpressOrderDSer extends Remote{
	public boolean create(ExpressPO order) throws RemoteException;
}
