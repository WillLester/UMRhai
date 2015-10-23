package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.stockDSer.StockCheckWarnDSer;

public class StockCheckWarnData extends UnicastRemoteObject implements StockCheckWarnDSer{

	protected StockCheckWarnData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<Integer> getWarning(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
