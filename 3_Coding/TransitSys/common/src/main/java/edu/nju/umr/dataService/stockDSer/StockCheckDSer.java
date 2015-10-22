package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.po.order.OrderPO;

public interface StockCheckDSer extends Remote{
	public ArrayList<OrderPO> getInOut(Date start,Date end,String id) throws RemoteException;

}
