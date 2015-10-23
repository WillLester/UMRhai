package edu.nju.umr.data.workOrgManData;

import edu.nju.umr.dataService.workOrgManDSer.OrgManDSer;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class OrgManData extends UnicastRemoteObject implements OrgManDSer{

	protected OrgManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<OrgPO> findOrg(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean addOrg(OrgPO org) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean deleteOrg(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean reviseOrg(OrgPO org) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public OrgPO checkOrg(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<CityPO> getCities() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
