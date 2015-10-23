package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.transitInfoDSer.CourierDSer;

public interface CourierDFacSer extends Remote{
	public CourierDSer getCourier() throws RemoteException;
}
