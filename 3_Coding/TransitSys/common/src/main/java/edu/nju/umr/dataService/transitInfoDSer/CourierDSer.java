package edu.nju.umr.dataService.transitInfoDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import edu.nju.umr.po.order.OrderPO;

public interface CourierDSer extends Remote{
	public OrderPO find(String barcode) throws RemoteException;
	
}
