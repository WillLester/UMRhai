package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.stockDSer.StockCheckWarnDSer;
import edu.nju.umr.po.StockPO;

public class StockCheckWarnData extends UnicastRemoteObject implements StockCheckWarnDSer{

	public StockCheckWarnData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<Integer> getWarning(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<Integer> ar=new ArrayList<Integer>();
		ar.add(1);
		ar.add(2);
		return ar;
	}

	public StockPO getStock(String stockId) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
