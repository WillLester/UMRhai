package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.ReceiveOrderDSer;

public interface ReceiveOrderDFacSer extends Remote{
	public ReceiveOrderDSer getReceiveOrder() throws RemoteException;
}
