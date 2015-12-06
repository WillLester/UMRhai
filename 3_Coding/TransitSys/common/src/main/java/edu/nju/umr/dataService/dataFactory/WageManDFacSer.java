package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.workOrgManDSer.WageManDSer;

public interface WageManDFacSer extends Remote{
	public WageManDSer getWageMan() throws RemoteException;
}
