package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.workOrgManDSer.OrgManDSer;

public interface OrgManDFacSer extends Remote{
	public OrgManDSer getOrgMan() throws RemoteException;
}
