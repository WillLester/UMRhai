package edu.nju.umr.data.cityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
/*
 * 城市数据
 */
public class CityData extends UnicastRemoteObject implements CityDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 702208404557174194L;
	MysqlService mysqlSer;
	public CityData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public Result addCity(CityPO city) throws RemoteException {
		return mysqlSer.addInfo(city, POKind.CITY);
		
	}

	public Result reviseCity(CityPO city) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(city, POKind.CITY);
	}

	public Result reviseCities(CitiesPO cities) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(cities, POKind.CITIES);
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

	public Result deleteCity(String cityName) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.deleteInfo(cityName, POKind.CITY);
	}

}
