package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.order.StockOutPO;

public interface StockOutOrderDSer extends Remote{
	public boolean create(StockOutPO order) throws RemoteException;
}
