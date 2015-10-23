package edu.nju.umr.dataService.workOrgManDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.WorkPO;

public interface WorkManDSer extends Remote{
	public ArrayList<WorkPO> findWork(String keyword) throws RemoteException;
	public boolean addWork(WorkPO work) throws RemoteException;
	public boolean deleteWork(String id) throws RemoteException;
	public boolean reviseWork(WorkPO work) throws RemoteException;
	public WorkPO checkWork(String id) throws RemoteException;
}
