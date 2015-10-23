package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;

public interface OrderResubmitDFacSer extends Remote{
	public OrderResubmitDSer getOrderResubmit() throws RemoteException;
}
