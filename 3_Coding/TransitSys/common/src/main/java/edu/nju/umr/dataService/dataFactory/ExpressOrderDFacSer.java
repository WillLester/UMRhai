package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.ExpressOrderDSer;

public interface ExpressOrderDFacSer extends Remote{
	public ExpressOrderDSer getExpressOrder() throws RemoteException;
}
