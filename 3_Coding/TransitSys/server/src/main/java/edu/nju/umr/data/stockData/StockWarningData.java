package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.databaseUtility.SerialHelper;
import edu.nju.umr.dataService.stockDSer.StockWarningDSer;
import edu.nju.umr.po.enums.Part;

public class StockWarningData extends UnicastRemoteObject implements StockWarningDSer{
	private static SerialHelper helper;
	
	public StockWarningData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<Integer> getWarning(String id) throws RemoteException {
		// TODO 自动生成的方法存根
	
		ArrayList<Integer> ar=new ArrayList<Integer>();
		ar.add(1);
		ar.add(2);
		return	(ArrayList<Integer>) helper.readFromFile("/data/stockWarning.ser");
	}

	public boolean setWarning( ArrayList<Integer> warn, String id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return helper.writeToFile(warn, "/data/stockWarning.ser");
	}

}
