package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;

public interface OrderApproveDFacSer extends Remote{
	public OrderApproveDSer getOrderApprove() throws RemoteException;
}
