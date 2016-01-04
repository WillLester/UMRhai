package edu.nju.umr.data.cityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	private MysqlService mysqlSer;
	private static CityData data = null;
	private CityData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static CityData getCity() throws RemoteException{
		if(data == null){
			data = new CityData();
		}
		return data;
	}

	public Result addCity(CityPO city) throws RemoteException {
		return mysqlSer.addInfo(city);
		
	}

	public Result reviseCity(CityPO city) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(city);
	}

	public Result reviseCities(CitiesPO cities) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(cities);
	}

	public Result deleteCity(String cityName) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.deleteInfo(new CityPO(cityName, null, null, 0));
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CitiesPO> getCitiesInfo() throws RemoteException {
		// TODO 自动生成的方法存根
		return (ArrayList<CitiesPO>) mysqlSer.checkAll(POKind.CITIES);
	}

	@Override
	public Result addCities(CitiesPO cities) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.addInfo(cities);
	}

	@Override
	public Result deleteCities(CitiesPO cities) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.deleteInfo(cities);
	}
	public Result isCityUsed(String name,String id,int key) throws RemoteException {
		ResultSet result=mysqlSer.checkInfo(new CityPO(name,id,null,key));
		if(result == null){
			return Result.DATABASE_ERROR;
		}
		try{
			if(result.next()){
				return Result.CITY_EXIST;
			}
		}catch(SQLException e){
			return Result.DATABASE_ERROR;
		}
		return Result.SUCCESS;
	}

}
