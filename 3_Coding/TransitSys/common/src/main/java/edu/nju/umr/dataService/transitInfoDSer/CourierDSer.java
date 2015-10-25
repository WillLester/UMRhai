package edu.nju.umr.dataService.transitInfoDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.order.ExpressPO;

public interface CourierDSer extends Remote{
	public ExpressPO find(String barcode) throws RemoteException;
	
}
