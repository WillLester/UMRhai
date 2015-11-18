package edu.nju.umr.data.utilityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;

public class UtilityData extends UnicastRemoteObject implements UtilityDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6578374576722125296L;
	private MysqlService mysqlSer;
	public UtilityData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		//mysqlSer = new MysqlImpl();
	}

	public ArrayList<CityPO> getCities() throws RemoteException {
		// TODO 自动生成的方法存根
		CityPO city1 = new CityPO("南京", "025","江苏");
		CityPO city2 = new CityPO("北京", "010","北京");
		ArrayList<CityPO> cities = new ArrayList<CityPO>();
		cities.add(city1);
		cities.add(city2);
		return cities;
	}

	public ArrayList<OrgPO> getOrgs() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<OrgPO> ar1=new ArrayList<OrgPO>();
		ar1.add(new OrgPO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityPO("南京","025","江苏")));
		ar1.add(new OrgPO("2","组织2",Organization.HALL,"南京大学鼓楼校区",new CityPO("南京","025","江苏")));
		return ar1;
	}
	public ArrayList<OrgPO> getHall() throws RemoteException {
		// TODO 自动生成的方法存根
		CityPO city = new CityPO("北京", "010","北京");
		OrgPO org = new OrgPO("00001", "HaHa", Organization.HALL, "香港记者", city);
		ArrayList<OrgPO> orgList = new ArrayList<OrgPO>();
		orgList.add(org);
		return orgList;
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
	public Result setRecord(Calendar cal,String op,String opt){
		System.out.println(cal+" "+op+" "+opt);
		System.out.println("数据层将操作日志存入数据库");
		return Result.SUCCESS;
	}

	public ArrayList<WorkPO> getWorkers(String OrgID) throws RemoteException {
		// TODO 自动生成的方法存根
		WorkPO work = new WorkPO("宝华", "12345678901","1", "00001", Jurisdiction.COURIER);
		ArrayList<WorkPO> workerList = new ArrayList<WorkPO>();
		workerList.add(work);
		return workerList;
	}

	public ArrayList<VanPO> getVans(String OrgID) throws RemoteException {
		// TODO 自动生成的方法存根
		VanPO van = new VanPO("00001", "苏A-12345", Calendar.getInstance(), null, "1");
		ArrayList<VanPO> vanList = new ArrayList<VanPO>();
		vanList.add(van);
		return vanList;
	}
	public ArrayList<AccountPO> getAccount() throws RemoteException{
		AccountPO account = new AccountPO(1, "Excited", 25000);
		ArrayList<AccountPO> accountList = new ArrayList<AccountPO>();
		accountList.add(account);
		return accountList;
	}

}
