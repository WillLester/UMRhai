package edu.nju.umr.dataService.utilityDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;

public interface UtilityDSer extends Remote{
	public ArrayList<CityPO> getCities() throws RemoteException;
	public ArrayList<OrgPO> getOrgs() throws RemoteException;
	public ArrayList<StockPO> getStocks() throws RemoteException;
}
