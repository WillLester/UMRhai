package edu.nju.umr.dataService.accountDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;

public interface CountDSer extends Remote{
	public Result addCount(CountPO count) throws RemoteException;
	public CountPO findInitInfo(String id) throws RemoteException;
//	public ArrayList<OrgPO> findOrg() throws RemoteException;
//	public ArrayList<WorkPO> getWorkers() throws RemoteException;
//	public ArrayList<VanPO> getVans() throws RemoteException;
//	public ArrayList<StockPO> getStocks() throws RemoteException;
//	public ArrayList<AccountPO> getAccount() throws RemoteException;
}
