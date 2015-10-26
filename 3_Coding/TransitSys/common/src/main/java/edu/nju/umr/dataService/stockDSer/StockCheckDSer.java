package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;

public interface StockCheckDSer extends Remote{
	public ArrayList<StockInPO> getIn(Date start,Date end,String id) throws RemoteException;
	public ArrayList<StockOutPO> getOut(Date start,Date end,String id) throws RemoteException;

}
