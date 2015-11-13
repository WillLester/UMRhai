package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.TransitInfoPO;

public interface UpdateTransitInfoDSer extends Remote{
	public boolean addInfo(TransitInfoPO info) throws RemoteException;
	public boolean update(TransitInfoPO info) throws RemoteException;
}
