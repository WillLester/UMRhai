package edu.nju.umr.data.utilityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;

public class UtilityData extends UnicastRemoteObject implements UtilityDSer{
	private MysqlService mysqlSer;
	public UtilityData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<CityPO> getCities() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<OrgPO> getOrgs() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<StockPO> getStocks() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
