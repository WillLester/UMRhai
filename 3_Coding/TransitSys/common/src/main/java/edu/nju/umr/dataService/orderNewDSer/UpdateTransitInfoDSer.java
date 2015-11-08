package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpdateTransitInfoDSer extends Remote{
	public boolean update(String id,String info) throws RemoteException;
}
