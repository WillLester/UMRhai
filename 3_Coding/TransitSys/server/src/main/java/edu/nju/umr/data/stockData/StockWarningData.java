package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.data.databaseUtility.SerialHelper;
import edu.nju.umr.dataService.stockDSer.StockWarningDSer;
import edu.nju.umr.po.enums.Result;

public class StockWarningData extends UnicastRemoteObject implements StockWarningDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8891271945349984048L;

	public StockWarningData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<Integer> getWarning(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		@SuppressWarnings("unchecked")
		ArrayList<Integer> warnings = (ArrayList<Integer>) SerialHelper.readFromFile("data/stockWarning/"+id+".ser");
		return warnings;
	}

	public Result setWarning(List<Integer> warnings, String id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return SerialHelper.writeToFile(warnings, "data/stockWarning/"+id+".ser");
	}

}
