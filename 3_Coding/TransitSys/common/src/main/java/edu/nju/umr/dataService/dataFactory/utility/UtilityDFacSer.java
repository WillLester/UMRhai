package edu.nju.umr.dataService.dataFactory.utility;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.utilityDSer.UtilityDSer;

public interface UtilityDFacSer extends Remote{
	public UtilityDSer getUtility() throws RemoteException;
}
