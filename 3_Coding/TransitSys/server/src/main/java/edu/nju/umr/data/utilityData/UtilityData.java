package edu.nju.umr.data.utilityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Organization;
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
		mysqlSer = new MysqlImpl();
	}

	public ArrayList<CityPO> getCities() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<OrgPO> getOrgs() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
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
		return null;
	}
	public Result setRecord(Calendar cal,String op,String opt){
		System.out.println(cal+" "+op+" "+opt);
		System.out.println("数据层将操作日志存入数据库");
		return Result.SUCCESS;
	}

	public ArrayList<WorkPO> getWorkers() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<VanPO> getVans() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
