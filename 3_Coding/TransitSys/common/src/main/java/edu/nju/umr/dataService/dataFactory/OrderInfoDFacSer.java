package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.utilityDSer.OrderInfoDSer;

public interface OrderInfoDFacSer extends Remote{
	public OrderInfoDSer getOrderInfo() throws RemoteException;
}
