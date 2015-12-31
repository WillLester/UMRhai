package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.cityDSer.CityDSer;

public interface CityDFacSer extends Remote{
	public CityDSer getCity() throws RemoteException;
}
