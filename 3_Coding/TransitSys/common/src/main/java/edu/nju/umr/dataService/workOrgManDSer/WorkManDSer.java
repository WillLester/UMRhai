package edu.nju.umr.dataService.workOrgManDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;

public interface WorkManDSer extends Remote{
	public ArrayList<WorkPO> findWork(String keyword) throws RemoteException;
	public Result addWork(WorkPO work) throws RemoteException;
	public Result deleteWork(String id) throws RemoteException;
	public Result reviseWork(WorkPO work) throws RemoteException;
//	public WorkPO checkWork(String id) throws RemoteException;
	public ArrayList<OrgPO> getOrgs() throws RemoteException;
}
