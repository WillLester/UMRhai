package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.transitInfoDSer.CustomerDSer;

public interface CustomerDFacSer extends Remote{
	public CustomerDSer getCustomer() throws RemoteException;
}
