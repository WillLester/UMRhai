package edu.nju.umr.dataService.workOrgManDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.OrgPO;

public interface WorkManDSer extends Remote{
	public ArrayList<OrgPO> findOrg(String keyword) throws RemoteException;
	public boolean addOrg(OrgPO org) throws RemoteException;
	public boolean deleteOrg(String id) throws RemoteException;
	public boolean reviseOrg(OrgPO org) throws RemoteException;
	public OrgPO checkOrg(String id) throws RemoteException;
}
