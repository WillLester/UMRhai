package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockInPO;

public interface StockInOrderDSer extends Remote{
	public Result create(StockInPO order) throws RemoteException;
//	public ArrayList<String> getCities() throws RemoteException;
}
