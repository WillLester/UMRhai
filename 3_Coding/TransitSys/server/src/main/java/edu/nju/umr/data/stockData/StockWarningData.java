package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.stockDSer.StockWarningDSer;
import edu.nju.umr.po.enums.Part;

public class StockWarningData extends UnicastRemoteObject implements StockWarningDSer{

	public StockWarningData() throws RemoteException {
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

	public boolean setWarning(int w, Part part, String id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

}
