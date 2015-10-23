package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.CenterLoadingOrderDSer;

public interface CenterLoadingOrderDFacSer extends Remote{
	public CenterLoadingOrderDSer getCenterLoadingOrder() throws RemoteException;
}
