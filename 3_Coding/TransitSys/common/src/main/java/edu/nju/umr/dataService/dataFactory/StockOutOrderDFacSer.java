package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.StockOutOrderDSer;

public interface StockOutOrderDFacSer extends Remote{
	public StockOutOrderDSer getStockOutOrder() throws RemoteException;
}
