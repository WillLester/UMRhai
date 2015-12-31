package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;

public interface StockCheckDSer extends Remote{
	public ArrayList<StockInPO> getIn(Calendar start,Calendar end,String id) throws RemoteException;
	public ArrayList<StockOutPO> getOut(Calendar start,Calendar end,String id) throws RemoteException;

}
