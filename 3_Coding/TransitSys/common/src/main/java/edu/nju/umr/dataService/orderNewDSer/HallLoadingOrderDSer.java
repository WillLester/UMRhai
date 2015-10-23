package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.order.HallLoadingPO;

public interface HallLoadingOrderDSer extends Remote{
	public boolean create(HallLoadingPO order) throws RemoteException;
}
