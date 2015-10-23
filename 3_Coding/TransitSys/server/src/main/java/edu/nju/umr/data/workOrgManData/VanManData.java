package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.workOrgManDSer.VanManDSer;
import edu.nju.umr.po.VanPO;

public class VanManData extends UnicastRemoteObject implements VanManDSer{

	protected VanManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<VanPO> findVan(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean addVan(VanPO Van) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean deleteVan(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean reviseVan(VanPO Van) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public VanPO checkVan(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
