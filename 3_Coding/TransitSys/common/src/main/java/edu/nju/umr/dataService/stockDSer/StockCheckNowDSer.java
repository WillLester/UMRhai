package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.StockPO;

public interface StockCheckNowDSer extends Remote{
	public StockPO getStock(String id) throws RemoteException;
}
