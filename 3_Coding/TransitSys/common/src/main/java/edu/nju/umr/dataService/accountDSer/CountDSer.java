package edu.nju.umr.dataService.accountDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.enums.Result;
/**
 * 
 * @author WillLester
 * @see CountData
 */
public interface CountDSer extends Remote{
	public Result addCount(CountPO count) throws RemoteException;
	/**
	 * 
	 * @param id 账的编号
	 * @return CountPO 账的PO
	 * @throws RemoteException
	 */
	public CountPO findInitInfo(int id) throws RemoteException;
//	public ArrayList<OrgPO> findOrg() throws RemoteException;
//	public ArrayList<WorkPO> getWorkers() throws RemoteException;
//	public ArrayList<VanPO> getVans() throws RemoteException;
//	public ArrayList<StockPO> getStocks() throws RemoteException;
//	public ArrayList<AccountPO> getAccount() throws RemoteException;
	public ArrayList<CountPO> getCount() throws RemoteException;
	public Result deleteCount(int id) throws RemoteException;
}
