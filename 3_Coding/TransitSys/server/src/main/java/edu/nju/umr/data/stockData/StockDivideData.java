package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.stockDSer.StockDivideDSer;
import edu.nju.umr.po.ShelfPO;

public class StockDivideData extends UnicastRemoteObject implements StockDivideDSer{

	protected StockDivideData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<ShelfPO> getShelves(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean addShelf(ShelfPO shelf) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean deleteShelf(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean reviseShelf(ShelfPO shelf) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public ShelfPO getShelf(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
