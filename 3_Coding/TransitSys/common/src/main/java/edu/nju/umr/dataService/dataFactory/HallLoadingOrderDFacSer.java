package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;

public interface HallLoadingOrderDFacSer extends Remote{
	public HallLoadingOrderDSer getHallLoadingOrder() throws RemoteException;
}
