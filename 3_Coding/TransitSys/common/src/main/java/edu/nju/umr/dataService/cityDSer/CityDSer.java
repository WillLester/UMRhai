package edu.nju.umr.dataService.cityDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.enums.Result;

public interface CityDSer extends Remote{
	public Result addCity(CityPO city) throws RemoteException;
	public Result reviseCity(CityPO city) throws RemoteException;
	public Result deleteCity(String cityName) throws RemoteException;
	public Result addCities(CitiesPO cities) throws RemoteException;
	public Result reviseCities(CitiesPO cities) throws RemoteException;
	public ArrayList<CitiesPO> getCitiesInfo() throws RemoteException;
}
