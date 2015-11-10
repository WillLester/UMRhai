package edu.nju.umr.data.accountData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.SerialHelper;
import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Part;
/*
 * 账数据
 */
public class CountData extends UnicastRemoteObject implements CountDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3199440496716511453L;
	public CountData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean addCount(CountPO count) throws RemoteException {
		return SerialHelper.writeToFile(count, "data/count.ser");
		
	}

	public CountPO findInitInfo(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		CityPO city = new CityPO("北京", "010","北京");
		OrgPO org = new OrgPO("00001", "HaHa", Organization.HALL, "香港记者", city);
		ArrayList<OrgPO> orgList = new ArrayList<OrgPO>();
		orgList.add(org);
		WorkPO work = new WorkPO("宝华", "12345678901", "00001", "00001", Jurisdiction.COURIER);
		ArrayList<WorkPO> workerList = new ArrayList<WorkPO>();
		workerList.add(work);
		VanPO van = new VanPO("00001", "苏A-12345",Calendar.getInstance(), null, "00001");
		ArrayList<VanPO> vanList = new ArrayList<VanPO>();
		vanList.add(van);
		GoodPO good = new GoodPO("00001", "00001", Calendar.getInstance(), "北京", Part.TRAIN, "T00001", 3, 5);
		ArrayList<GoodPO> goodList = new ArrayList<GoodPO>();
		goodList.add(good);
		StockPO stock = new StockPO("00001",goodList);
		ArrayList<StockPO> stockList = new ArrayList<StockPO>();
		stockList.add(stock);
		AccountPO account = new AccountPO("00001", "Excited", 25000);
		ArrayList<AccountPO> accountList = new ArrayList<AccountPO>();
		accountList.add(account);
		return (CountPO) SerialHelper.readFromFile("data/count.ser");
	}

	public ArrayList<OrgPO> findOrg() throws RemoteException {
		// TODO 自动生成的方法存根
		CityPO city = new CityPO("北京", "010","北京");
		OrgPO org = new OrgPO("00001", "HaHa", Organization.HALL, "香港记者", city);
		ArrayList<OrgPO> orgList = new ArrayList<OrgPO>();
		orgList.add(org);
		return orgList;
	}

	public ArrayList<WorkPO> getWorkers() throws RemoteException {
		// TODO 自动生成的方法存根
		WorkPO work = new WorkPO("宝华", "12345678901","1", "00001", Jurisdiction.COURIER);
		ArrayList<WorkPO> workerList = new ArrayList<WorkPO>();
		workerList.add(work);
		return workerList;
	}

	public ArrayList<VanPO> getVans() throws RemoteException {
		// TODO 自动生成的方法存根
		VanPO van = new VanPO("00001", "苏A-12345", Calendar.getInstance(), null, "1");
		ArrayList<VanPO> vanList = new ArrayList<VanPO>();
		vanList.add(van);
		return vanList;
	}

	public ArrayList<StockPO> getStocks() throws RemoteException {
		// TODO 自动生成的方法存根
		GoodPO good = new GoodPO("00001", "00001",Calendar.getInstance(), "北京", Part.TRAIN, "T00001", 3, 5);
		ArrayList<GoodPO> goodList = new ArrayList<GoodPO>();
		goodList.add(good);
		StockPO stock = new StockPO("00001",goodList);
		ArrayList<StockPO> stockList = new ArrayList<StockPO>();
		stockList.add(stock);
		return stockList;
	}

	public ArrayList<AccountPO> getAccount() throws RemoteException {
		// TODO 自动生成的方法存根
		AccountPO account = new AccountPO("00001", "Excited", 25000);
		ArrayList<AccountPO> accountList = new ArrayList<AccountPO>();
		accountList.add(account);
		return accountList;
	}
	
}
