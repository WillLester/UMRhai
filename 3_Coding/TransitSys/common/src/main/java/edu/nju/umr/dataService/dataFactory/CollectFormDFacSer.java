package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.checkDSer.CollectRecordDSer;

public interface CollectFormDFacSer extends Remote{
	public CollectRecordDSer getCollectForm() throws RemoteException;
}
