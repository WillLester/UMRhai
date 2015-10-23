package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.workOrgManDSer.WorkManDSer;
import edu.nju.umr.po.WorkPO;

public class OrgManData extends UnicastRemoteObject implements WorkManDSer{

	protected OrgManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<WorkPO> findWork(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean addWork(WorkPO work) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean deleteWork(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean reviseWork(WorkPO work) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public WorkPO checkWork(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
