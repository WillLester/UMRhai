package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import edu.nju.umr.dataService.stockDSer.StockCheckNowDSer;
import edu.nju.umr.po.StockPO;

public class StockCheckNowData extends UnicastRemoteObject implements StockCheckNowDSer{

	protected StockCheckNowData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public StockPO getStock(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean setPoint(String id, Date date) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

}
