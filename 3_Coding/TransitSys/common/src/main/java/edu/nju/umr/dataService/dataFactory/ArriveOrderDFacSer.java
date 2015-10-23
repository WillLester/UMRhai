package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.ArriveOrderDSer;

public interface ArriveOrderDFacSer extends Remote{
	public ArriveOrderDSer getArriveOrder() throws RemoteException;
}
