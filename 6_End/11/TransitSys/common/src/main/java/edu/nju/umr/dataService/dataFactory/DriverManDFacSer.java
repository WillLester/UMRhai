package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.workOrgManDSer.DriverManDSer;

public interface DriverManDFacSer extends Remote{
	public DriverManDSer getDriverMan() throws RemoteException;
}
