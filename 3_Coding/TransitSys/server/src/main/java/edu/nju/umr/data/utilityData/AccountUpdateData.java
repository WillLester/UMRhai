package edu.nju.umr.data.utilityData;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.utilityDSer.AccountUpdateDSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.enums.Result;

public class AccountUpdateData extends UnicastRemoteObject implements AccountUpdateDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -853957620119732651L;
	private MysqlService mysqlSer;
	private static AccountUpdateData data = null;
	private AccountUpdateData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	public static AccountUpdateData getAccountUp() throws RemoteException{
		if(data == null){
			data = new AccountUpdateData();
		}
		return data;
	}
	

	@Override
	public Result income(String account, BigDecimal amount)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new AccountPO(0, account, new BigDecimal(0)));
		ArrayList<AccountPO> accountList = ArrayListFactory.produceAccountList(result);
		if(accountList == null){
			return Result.DATABASE_ERROR;
		}
		for(AccountPO accountPO:accountList){
			if(accountPO.getName().equals(account)){
				BigDecimal ori = accountPO.getBalance();
				ori = ori.add(amount);
				AccountPO newAccount = new AccountPO(accountPO.getId(), account, ori);
				return mysqlSer.reviseInfo(newAccount);
			}
		}
		return null;
	}

	@Override
	public Result pay(String account, BigDecimal amount) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new AccountPO(0, account, null));
		ArrayList<AccountPO> accountList = ArrayListFactory.produceAccountList(result);
		if(accountList == null){
			return Result.DATABASE_ERROR;
		}
		for(AccountPO po:accountList){
			if(po.getName().equals(account)){
				BigDecimal balance = po.getBalance();
				balance = balance.subtract(amount);
				AccountPO newAccount = new AccountPO(po.getId(), account, balance);
				return mysqlSer.reviseInfo(newAccount);
			}
		}
		return Result.DATA_NOT_FOUND;
	}
	

}
