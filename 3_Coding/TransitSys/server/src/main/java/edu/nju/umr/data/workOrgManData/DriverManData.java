package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.workOrgManDSer.DriverManDSer;
import edu.nju.umr.po.DriverPO;

public class DriverManData extends UnicastRemoteObject implements DriverManDSer{

	protected DriverManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<DriverPO> findDriver(String keyword)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean addDriver(DriverPO Driver) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean deleteDriver(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean reviseDriver(DriverPO Driver) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public DriverPO checkDriver(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
