package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.userDSer.LoginDSer;

public interface LoginDFacSer extends Remote{
	public LoginDSer getLogin() throws RemoteException;
}
