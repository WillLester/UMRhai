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

public interface CountDSer extends Remote{
	public boolean addCount(CountPO count) throws RemoteException;
	public CountPO findInitInfo() throws RemoteException;
	public ArrayList<OrgPO> findOrg() throws RemoteException;
	public ArrayList<WorkPO> getWorkers(String id) throws RemoteException;
	public ArrayList<VanPO> getVans(String id) throws RemoteException;
	public ArrayList<StockPO> getStock(String id) throws RemoteException;
	public ArrayList<AccountPO> getAccount(String id) throws RemoteException;
}
