package edu.nju.umr.dataService.dataFactory.utility;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderApproveDSer.AccountUpdateDSer;

public interface AccountUpdateDFacSer extends Remote{
	public AccountUpdateDSer getAccountUp() throws RemoteException;
}
