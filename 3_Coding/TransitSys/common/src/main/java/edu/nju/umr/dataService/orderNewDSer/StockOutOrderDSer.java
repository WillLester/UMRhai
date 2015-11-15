package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockOutPO;

public interface StockOutOrderDSer extends Remote{
	public Result create(StockOutPO order) throws RemoteException;
	public ArrayList<String> getCities() throws RemoteException;
}
