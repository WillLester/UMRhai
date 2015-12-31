package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.stockDSer.StockCheckWarnDSer;

public interface StockCheckWarnDFacSer extends Remote{
	public StockCheckWarnDSer getStockCheckWarn() throws RemoteException;
}
