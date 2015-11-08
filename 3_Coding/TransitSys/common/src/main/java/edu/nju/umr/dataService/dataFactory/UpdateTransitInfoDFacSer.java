package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.UpdateTransitInfoDSer;

public interface UpdateTransitInfoDFacSer extends Remote{
	public UpdateTransitInfoDSer getUpdateTransitInfoDSer() throws RemoteException;

}
