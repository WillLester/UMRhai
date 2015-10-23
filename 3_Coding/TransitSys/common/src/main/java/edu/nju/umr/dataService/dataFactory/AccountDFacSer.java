package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.accountDSer.AccountDSer;

public interface AccountDFacSer extends Remote{
	public AccountDSer getAccountData() throws RemoteException;
}
