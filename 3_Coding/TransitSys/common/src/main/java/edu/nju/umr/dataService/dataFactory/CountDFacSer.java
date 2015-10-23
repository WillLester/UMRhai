package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.accountDSer.CountDSer;

public interface CountDFacSer extends Remote{
	public CountDSer getCountData() throws RemoteException;
}
