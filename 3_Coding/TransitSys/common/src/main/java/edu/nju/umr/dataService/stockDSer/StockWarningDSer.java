package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;

public interface StockWarningDSer extends Remote{
	public ArrayList<Integer> getWarning(String id) throws RemoteException;
	public Result setWarning(int w,Part part,String id) throws RemoteException;
	
}
