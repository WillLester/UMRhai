package edu.nju.umr.dataService.transitInfoDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CustomerDSer extends Remote{
	public ArrayList<String> findTransit(String barcode) throws RemoteException;
}
