package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.workOrgManDSer.WageManDSer;
import edu.nju.umr.po.WagePO;
import edu.nju.umr.po.WorkPO;

public class WageManData extends UnicastRemoteObject implements WageManDSer{

	public WageManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<WorkPO> findWork(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean reviseWage(WagePO wage) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public WagePO getWage(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
