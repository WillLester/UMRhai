package edu.nju.umr.dataService.workOrgManDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.DriverPO;

public interface DriverManDSer extends Remote{
//	public ArrayList<DriverPO> findDriver(String keyword) throws RemoteException;
	public ArrayList<DriverPO> driverList() throws RemoteException;
	public boolean addDriver(DriverPO driver) throws RemoteException;
	public boolean deleteDriver(String id) throws RemoteException;
	public boolean reviseDriver(DriverPO driver) throws RemoteException;
	public DriverPO checkDriver(String id) throws RemoteException;
}
