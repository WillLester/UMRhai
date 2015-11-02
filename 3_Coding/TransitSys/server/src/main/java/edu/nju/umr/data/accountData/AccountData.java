package edu.nju.umr.data.accountData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.accountDSer.AccountDSer;
import edu.nju.umr.po.AccountPO;

@SuppressWarnings("serial")
public class AccountData extends UnicastRemoteObject implements AccountDSer{


	public AccountData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<AccountPO> findAccount(String keyword)
			throws RemoteException {
		// TODO 自动生成的方法存根
		AccountPO account1 = new AccountPO("00001", "Excited", 25000);
		AccountPO account2 = new AccountPO("00002", "Too Young",30000);
		ArrayList<AccountPO> list = new ArrayList<AccountPO>();
		list.add(account1);
		list.add(account2);
		return list;
	}

	public boolean addAccount(AccountPO account) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteAccount(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseAccount(AccountPO account) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

//	public AccountPO checkAccount(String id) throws RemoteException {
//		// TODO 自动生成的方法存根
//		AccountPO account = new AccountPO(id, "Excited", 25000);
//		return account;
//	}

}
