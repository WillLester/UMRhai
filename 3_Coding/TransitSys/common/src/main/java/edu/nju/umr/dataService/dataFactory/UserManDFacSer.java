package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.userDSer.UserManDSer;

public interface UserManDFacSer extends Remote{
	public UserManDSer getUserMan() throws RemoteException;
}
