package edu.nju.umr.dataService.workOrgManDSer;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.VanPO;

public interface VanManDSer {
	public ArrayList<VanPO> findVan(String keyword) throws RemoteException;
	public boolean addVan(VanPO Van) throws RemoteException;
	public boolean deleteVan(String id) throws RemoteException;
	public boolean reviseVan(VanPO Van) throws RemoteException;
	public VanPO checkVan(String id) throws RemoteException;
}
