package edu.nju.umr.data.accountData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		ArrayList<AccountPO> accountList = new ArrayList<AccountPO>();
		if(keyword != null){
			ResultSet result = mysqlSer.checkInfo(new AccountPO(0, keyword, 0));
			try {
				while(result.next()){
					AccountPO account = new AccountPO(result.getInt(1), result.getString(2), result.getDouble(3));
					accountList.add(account);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				return null;
			}
		} else {
			return (ArrayList<AccountPO>) mysqlSer.checkAll(POKind.ACCOUNT);
		}
		return accountList;
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

}
