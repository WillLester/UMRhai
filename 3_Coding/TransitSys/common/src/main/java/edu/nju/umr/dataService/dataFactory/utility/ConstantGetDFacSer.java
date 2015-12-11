package edu.nju.umr.dataService.dataFactory.utility;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.utilityDSer.ConstantGetDSer;

public interface ConstantGetDFacSer extends Remote{
	public ConstantGetDSer getConstantGet() throws RemoteException;
}
