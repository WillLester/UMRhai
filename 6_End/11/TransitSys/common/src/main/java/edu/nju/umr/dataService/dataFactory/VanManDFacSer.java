package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.workOrgManDSer.VanManDSer;

public interface VanManDFacSer extends Remote{
	public VanManDSer getVanMan() throws RemoteException;
}
