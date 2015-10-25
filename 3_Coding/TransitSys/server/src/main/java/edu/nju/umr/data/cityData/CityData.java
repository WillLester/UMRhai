package edu.nju.umr.data.cityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;

public class CityData extends UnicastRemoteObject implements CityDSer{

	public CityData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean add(CityPO city) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean revise(CityPO city) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseCities(CitiesPO cities) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

}
