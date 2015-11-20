package edu.nju.umr.dataService.workOrgManDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.enums.Result;

public interface DriverManDSer extends Remote{
	public ArrayList<DriverPO> findDriver(String keyword) throws RemoteException;
//	public ArrayList<DriverPO> driverList() throws RemoteException;
	public Result addDriver(DriverPO driver) throws RemoteException;
	public Result deleteDriver(String id) throws RemoteException;
	public Result reviseDriver(DriverPO driver) throws RemoteException;
	public DriverPO checkDriver(String id) throws RemoteException;
}
