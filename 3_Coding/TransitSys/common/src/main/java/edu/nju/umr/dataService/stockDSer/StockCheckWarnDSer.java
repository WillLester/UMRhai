package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface StockCheckWarnDSer extends Remote{
	public ArrayList<Integer> getWarning(String id) throws RemoteException;
}
