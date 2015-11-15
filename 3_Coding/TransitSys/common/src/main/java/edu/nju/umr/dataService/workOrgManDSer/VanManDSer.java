package edu.nju.umr.dataService.workOrgManDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.enums.Result;

public interface VanManDSer extends Remote{
	public ArrayList<VanPO> findVan(String keyword) throws RemoteException;
	public Result addVan(VanPO van) throws RemoteException;
	public Result deleteVan(String id) throws RemoteException;
	public Result reviseVan(VanPO van) throws RemoteException;
	public VanPO checkVan(String id) throws RemoteException;
}
