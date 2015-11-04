package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.StockPO;

public interface StockCheckWarnDSer extends Remote{
	public ArrayList<Integer> getWarning(String id) throws RemoteException;
	public StockPO getStock(String stockId) throws RemoteException;
}
