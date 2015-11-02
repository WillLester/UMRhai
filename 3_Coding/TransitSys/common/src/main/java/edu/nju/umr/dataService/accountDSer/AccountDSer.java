package edu.nju.umr.dataService.accountDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.AccountPO;

public interface AccountDSer extends Remote{
	public ArrayList<AccountPO> findAccount(String keyword) throws RemoteException;
	public boolean addAccount(AccountPO account) throws RemoteException;
	public boolean deleteAccount(String id) throws RemoteException;
	public boolean reviseAccount(AccountPO account) throws RemoteException;
//	public AccountPO checkAccount(String id) throws RemoteException;
}
