package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.workOrgManDSer.WorkManDSer;

public interface WorkManDFacSer extends Remote{
	public WorkManDSer getWorkMan() throws RemoteException;
}
