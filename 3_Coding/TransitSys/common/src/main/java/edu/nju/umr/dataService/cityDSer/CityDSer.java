package edu.nju.umr.dataService.cityDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;

public interface CityDSer extends Remote{
	public boolean addCity(CityPO city) throws RemoteException;
	public boolean reviseCity(CityPO city) throws RemoteException;
	public boolean deleteCity(String cityName) throws RemoteException;
	public boolean reviseCities(CitiesPO cities) throws RemoteException;
	public ArrayList<CityPO> getCities() throws RemoteException;
}
