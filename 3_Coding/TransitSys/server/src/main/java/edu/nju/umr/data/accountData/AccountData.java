package edu.nju.umr.data.accountData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.accountDSer.AccountDSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.enums.POKind;
/*
 * 账户数据
 */
import edu.nju.umr.po.enums.Result;

public class AccountData extends UnicastRemoteObject implements AccountDSer{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2848922847340119380L;
	MysqlService mysqlSer;
	public AccountData() throws RemoteException {
		super();
		mysqlSer = new MysqlImpl();
		// TODO 自动生成的构造函数存根
	}

	@SuppressWarnings("unchecked")
	public ArrayList<AccountPO> findAccount(String keyword)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return (ArrayList<AccountPO>) mysqlSer.checkInfo(keyword, POKind.ACCOUNT);
	}

	public Result addAccount(AccountPO account) throws RemoteException {
		return mysqlSer.addInfo(account);
	}

	public Result deleteAccount(int id) throws RemoteException {
		return mysqlSer.deleteInfo(new AccountPO(id, null, 0));
	}

	public Result reviseAccount(AccountPO account) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(account);
	}

//	public AccountPO checkAccount(String id) throws RemoteException {
//		// TODO 自动生成的方法存根
//		AccountPO account = new AccountPO(id, "Excited", 25000);
//		return account;
//	}

}
