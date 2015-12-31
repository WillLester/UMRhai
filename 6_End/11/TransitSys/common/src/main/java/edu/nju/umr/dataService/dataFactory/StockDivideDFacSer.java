package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.stockDSer.StockDivideDSer;

public interface StockDivideDFacSer extends Remote{
	public StockDivideDSer getStockDivide() throws RemoteException;
}
