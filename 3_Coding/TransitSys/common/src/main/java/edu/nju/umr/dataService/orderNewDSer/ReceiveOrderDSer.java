package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.order.ReceivePO;

public interface ReceiveOrderDSer extends Remote{
	public boolean create(ReceivePO order) throws RemoteException;
}
