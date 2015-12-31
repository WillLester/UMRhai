package edu.nju.umr.data.accountData;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
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
	private MysqlService mysqlSer;
	private static AccountData account= null;
	private AccountData() throws RemoteException {
		super();
		mysqlSer = MysqlImpl.getMysql();
		// TODO 自动生成的构造函数存根
	}
	
	public static AccountData getAccountData() throws RemoteException{
		if(account == null){
			account = new AccountData();
		}
		return account;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<AccountPO> findAccount(String keyword)
			throws RemoteException {
		if(keyword != null){
			ResultSet result = mysqlSer.checkInfo(new AccountPO(0, keyword, new BigDecimal(0)));
			return ArrayListFactory.produceAccountList(result);
		} else {
			return (ArrayList<AccountPO>) mysqlSer.checkAll(POKind.ACCOUNT);
		}
	}

	public Result addAccount(AccountPO account) throws RemoteException {
		return mysqlSer.addInfo(account);
	}

	public Result deleteAccount(int id) throws RemoteException {
		return mysqlSer.deleteInfo(new AccountPO(id, null, new BigDecimal(0)));
	}

	public Result reviseAccount(AccountPO account) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(account);
	}

}
