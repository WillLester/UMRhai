package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.stockDSer.StockWarningDSer;

public class StockWarningData extends UnicastRemoteObject implements StockWarningDSer{

	protected StockWarningData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<Integer> getWarning(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean setWarning(int w, int part, String id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

}
