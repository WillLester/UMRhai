package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.stockDSer.StockDivideDSer;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Part;

public class StockDivideData extends UnicastRemoteObject implements StockDivideDSer{

	public StockDivideData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<ShelfPO> getShelves(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<ShelfPO> ar=new ArrayList<ShelfPO>();
		ar.add(new ShelfPO("1",1,1,Part.PLANE));
		ar.add(new ShelfPO("2",3,4,Part.TRAIN));
		return ar;
	}

	public boolean addShelf(ShelfPO shelf) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteShelf(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseShelf(ShelfPO shelf) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public ShelfPO getShelf(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return new ShelfPO("2",3,4,Part.TRAIN);
		//return null;
	}

}
