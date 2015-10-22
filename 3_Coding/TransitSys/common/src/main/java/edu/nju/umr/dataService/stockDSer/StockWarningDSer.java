package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface StockWarningDSer extends Remote{
	public ArrayList<Integer> getWarning(String id) throws RemoteException;
	public boolean setWarning(int w,int part,String id) throws RemoteException;
	
}
