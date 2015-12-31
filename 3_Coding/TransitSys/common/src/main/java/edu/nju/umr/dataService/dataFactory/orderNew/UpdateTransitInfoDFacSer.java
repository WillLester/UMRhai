package edu.nju.umr.dataService.dataFactory.orderNew;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderApproveDSer.UpdateTransitInfoDSer;

public interface UpdateTransitInfoDFacSer extends Remote{
	public UpdateTransitInfoDSer getUpdateTransitInfoDSer() throws RemoteException;

}
