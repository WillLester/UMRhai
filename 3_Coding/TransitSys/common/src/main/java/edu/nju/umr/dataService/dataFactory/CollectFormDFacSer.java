package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.checkDSer.CollectFormDSer;

public interface CollectFormDFacSer extends Remote{
	public CollectFormDSer getCollectForm() throws RemoteException;
}
