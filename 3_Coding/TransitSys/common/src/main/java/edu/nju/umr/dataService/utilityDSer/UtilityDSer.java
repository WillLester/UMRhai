package edu.nju.umr.dataService.utilityDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.CityPO;

public interface UtilityDSer extends Remote{
	public ArrayList<CityPO> getCities() throws RemoteException;
}
