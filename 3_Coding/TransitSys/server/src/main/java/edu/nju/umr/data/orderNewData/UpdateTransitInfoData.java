package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.orderNewDSer.UpdateTransitInfoDSer;

public class UpdateTransitInfoData extends UnicastRemoteObject implements UpdateTransitInfoDSer{
	public UpdateTransitInfoData()throws RemoteException{
		super();
	}
	public boolean update(String id,String info) throws RemoteException
	{
		
		
		
		return true;
	}

}
