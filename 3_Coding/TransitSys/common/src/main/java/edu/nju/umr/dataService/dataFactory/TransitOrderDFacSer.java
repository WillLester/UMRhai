package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.TransitOrderDSer;

public interface TransitOrderDFacSer extends Remote{
	public TransitOrderDSer getTransitOrder() throws RemoteException;
}