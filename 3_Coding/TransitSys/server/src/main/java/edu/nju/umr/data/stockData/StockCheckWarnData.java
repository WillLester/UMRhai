package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.dataService.stockDSer.StockCheckWarnDSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.enums.Part;

public class StockCheckWarnData extends UnicastRemoteObject implements StockCheckWarnDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2620162538190055811L;
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
		GoodPO good = new GoodPO("00001", "00001", Calendar.getInstance(), "北京", Part.TRAIN, "T00001", 3, 5);
		ArrayList<GoodPO> goodList = new ArrayList<GoodPO>();
		goodList.add(good);
		StockPO stock = new StockPO("00001",goodList);
		return stock;
	}

	public ArrayList<ShelfPO> getShelves(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<ShelfPO> ar=new ArrayList<ShelfPO>();
		ar.add(new ShelfPO("1","00001",1,1,Part.PLANE));
		ar.add(new ShelfPO("2","00001",3,4,Part.TRAIN));
		return ar;
	}

}
