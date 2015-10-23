package edu.nju.umr.dataService.workOrgManDSer;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.DriverPO;

public interface DriverManDSer {
	public ArrayList<DriverPO> findDriver(String keyword) throws RemoteException;
	public boolean addDriver(DriverPO Driver) throws RemoteException;
	public boolean deleteDriver(String id) throws RemoteException;
	public boolean reviseDriver(DriverPO Driver) throws RemoteException;
	public DriverPO checkDriver(String id) throws RemoteException;
}
