package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.stockDSer.StockCheckNowDSer;

public interface StockCheckNowDFacSer extends Remote{
	public StockCheckNowDSer getStockCheckNow() throws RemoteException;
}
