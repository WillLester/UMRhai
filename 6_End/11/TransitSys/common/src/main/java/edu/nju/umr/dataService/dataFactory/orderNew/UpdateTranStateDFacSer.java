package edu.nju.umr.dataService.dataFactory.orderNew;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderApproveDSer.UpdateTranStateDSer;

public interface UpdateTranStateDFacSer extends Remote{
	public UpdateTranStateDSer getUpdateTranState() throws RemoteException;
}
