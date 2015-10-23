package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.StockInOrderDSer;

public interface StockInOrderDFacSer extends Remote{
	public StockInOrderDSer getStockInOrder() throws RemoteException;
}
