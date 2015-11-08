package edu.nju.umr.data.cityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.enums.POKind;
/*
 * 城市数据
 */
public class CityData extends UnicastRemoteObject implements CityDSer{
	MysqlService mysqlSer;
	public CityData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean add(CityPO city) throws RemoteException {
		return mysqlSer.addInfo(city, POKind.CITY);
		
	}

	public boolean revise(CityPO city) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseCities(CitiesPO cities) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
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

}
