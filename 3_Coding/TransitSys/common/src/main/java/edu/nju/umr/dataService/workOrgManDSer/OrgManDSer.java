package edu.nju.umr.dataService.workOrgManDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.enums.Result;

public interface OrgManDSer extends Remote{
	public ArrayList<OrgPO> findOrg(String keyword) throws RemoteException;
	public Result addOrg(OrgPO org) throws RemoteException;
	public Result deleteOrg(String id) throws RemoteException;
	public Result reviseOrg(OrgPO org) throws RemoteException;
//	public OrgPO checkOrg(String id) throws RemoteException;
//	public ArrayList<CityPO> getCities() throws RemoteException;
}
