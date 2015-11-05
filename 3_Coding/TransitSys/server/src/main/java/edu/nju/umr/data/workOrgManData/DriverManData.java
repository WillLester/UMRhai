package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.dataService.workOrgManDSer.DriverManDSer;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.enums.Sex;

public class DriverManData extends UnicastRemoteObject implements DriverManDSer{

	public DriverManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<DriverPO> findDriver(String keyword)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<DriverPO> ar = new ArrayList<DriverPO>();
//		ar.add(new DriverPO("1","司机1",new Date(1900-01-01),"司机编号1","司机手机号1",Sex.MAN,new Date()));
//		ar.add(new DriverPO("2","司机2",new Date(1901-01-01),"司机编号2","司机手机号2",Sex.WOMAN,new Date()));
		return ar;
	}

	public boolean addDriver(DriverPO Driver) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteDriver(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseDriver(DriverPO Driver) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public DriverPO checkDriver(String id) throws RemoteException {
		// TODO 自动生成的方法存根
//		return new DriverPO("1","司机1",new Date(1900-01-01),"司机编号1","司机手机号1",Sex.MAN,new Date());
		return null;
	}

}
