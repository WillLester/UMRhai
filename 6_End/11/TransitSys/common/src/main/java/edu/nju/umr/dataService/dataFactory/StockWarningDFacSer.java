package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.stockDSer.StockWarningDSer;

public interface StockWarningDFacSer extends Remote{
	public StockWarningDSer getStockWarning() throws RemoteException;
}
