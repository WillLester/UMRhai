package edu.nju.umr.dataService.workOrgManDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.WagePO;
import edu.nju.umr.po.WorkPO;

public interface WageManDSer extends Remote{
	public ArrayList<WorkPO> findWork(String keyword) throws RemoteException;
	public boolean reviseWage(WagePO wage) throws RemoteException;
	public WagePO getWage(String id) throws RemoteException;
}
