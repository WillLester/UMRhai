package edu.nju.umr.data.accountData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.accountDSer.AccountDSer;
import edu.nju.umr.po.AccountPO;

@SuppressWarnings("serial")
public class AccountData extends UnicastRemoteObject implements AccountDSer{


	protected AccountData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<AccountPO> findAccount(String keyword)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean addAccount(AccountPO account) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean deleteAccount(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean reviseAccount(AccountPO account) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public AccountPO checkAccount(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
