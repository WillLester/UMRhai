package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.stockDSer.StockCheckDSer;

public interface StockCheckDFacSer extends Remote{
	public StockCheckDSer getStockCheck() throws RemoteException;
}
