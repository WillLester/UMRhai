package edu.nju.umr.dataService.utilityDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;

public interface UtilityDSer extends Remote{
	public ArrayList<CityPO> getCities() throws RemoteException;
	public ArrayList<OrgPO> getOrgs() throws RemoteException;
	public ArrayList<WorkPO> getWorkers(String OrgID) throws RemoteException;
	public ArrayList<VanPO> getVans(String OrgID) throws RemoteException;
	public ArrayList<StockPO> getStocks() throws RemoteException;
	public ArrayList<OrgPO> getHall() throws RemoteException;
	public ArrayList<AccountPO> getAccount() throws RemoteException;
	public ArrayList<OrgPO> getCenters()throws RemoteException;
	public ArrayList<WorkPO> getCouriers(String hallId) throws RemoteException;
}
