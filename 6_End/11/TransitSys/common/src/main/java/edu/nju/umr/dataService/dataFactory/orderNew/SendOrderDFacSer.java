package edu.nju.umr.dataService.dataFactory.orderNew;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.SendOrderDSer;

public interface SendOrderDFacSer extends Remote{
	public SendOrderDSer getSendOrder() throws RemoteException;
}
