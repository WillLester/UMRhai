package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Result;

public interface StockDivideDSer extends Remote{
	public ArrayList<ShelfPO> getShelves(String id,String keyword) throws RemoteException;
	public Result addShelf(ShelfPO shelf) throws RemoteException;
	public Result deleteShelf(String id) throws RemoteException;
	public Result reviseShelf(ShelfPO shelf) throws RemoteException;
//	public ShelfPO getShelf(String id) throws RemoteException;
}
