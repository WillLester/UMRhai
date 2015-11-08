package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.enums.Part;

public interface StockWarningDSer extends Remote{
	public ArrayList<Integer> getWarning(String id) throws RemoteException;
	public boolean setWarning(ArrayList<Integer> warn,String id) throws RemoteException;
	
}
