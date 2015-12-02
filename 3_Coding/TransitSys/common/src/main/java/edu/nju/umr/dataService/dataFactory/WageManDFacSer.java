package edu.nju.umr.dataService.dataFactory;

import java.rmi.RemoteException;

import edu.nju.umr.dataService.workOrgManDSer.WageManDSer;

public interface WageManDFacSer {
	public WageManDSer getWageMan() throws RemoteException;
}
