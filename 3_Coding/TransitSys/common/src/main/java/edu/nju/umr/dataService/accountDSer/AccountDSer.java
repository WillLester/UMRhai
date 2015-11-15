package edu.nju.umr.dataService.accountDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.enums.Result;

public interface AccountDSer extends Remote{
	public ArrayList<AccountPO> findAccount(String keyword) throws RemoteException;
	public Result addAccount(AccountPO account) throws RemoteException;
	public Result deleteAccount(String id) throws RemoteException;
	public Result reviseAccount(AccountPO account) throws RemoteException;
//	public AccountPO checkAccount(String id) throws RemoteException;
}
