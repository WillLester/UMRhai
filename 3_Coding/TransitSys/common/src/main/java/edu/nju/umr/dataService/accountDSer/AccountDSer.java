package edu.nju.umr.dataService.accountDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.enums.Result;
/**
 * 
 * @author WillLester
 * @see AccountData
 */
public interface AccountDSer extends Remote{
	/**
	 * 
	 * @param keyword 当关键词为null时返回全部
	 * @return 返回找到的AccountPO
	 * @throws RemoteException
	 */
	public ArrayList<AccountPO> findAccount(String keyword) throws RemoteException;
	public Result addAccount(AccountPO account) throws RemoteException;
	public Result deleteAccount(int id) throws RemoteException;
	public Result reviseAccount(AccountPO account) throws RemoteException;
//	public AccountPO checkAccount(String id) throws RemoteException;
}
