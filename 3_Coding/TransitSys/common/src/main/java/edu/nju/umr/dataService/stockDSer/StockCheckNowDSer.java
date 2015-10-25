package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import edu.nju.umr.po.StockPO;

public interface StockCheckNowDSer extends Remote{
	public StockPO getStock(String id) throws RemoteException;
	public boolean setPoint(String id,Date date) throws RemoteException;
	public boolean outputExcel(String location, StockPO stock) throws RemoteException;
}
