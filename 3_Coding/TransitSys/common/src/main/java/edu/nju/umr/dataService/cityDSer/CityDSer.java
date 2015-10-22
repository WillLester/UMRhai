package edu.nju.umr.dataService.cityDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;

public interface CityDSer extends Remote{
	public boolean add(CityPO city) throws RemoteException;
	public boolean revise(CityPO city) throws RemoteException;
	public boolean reviseCities(CitiesPO cities) throws RemoteException;
}
