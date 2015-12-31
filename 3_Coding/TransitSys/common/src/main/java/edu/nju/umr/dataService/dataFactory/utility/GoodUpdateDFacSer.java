package edu.nju.umr.dataService.dataFactory.utility;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.utilityDSer.GoodUpdateDSer;

public interface GoodUpdateDFacSer extends Remote{
	public GoodUpdateDSer getGoodUpdate() throws RemoteException;
}
