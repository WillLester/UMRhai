package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.ShelfPO;

public interface StockDivideDSer extends Remote{
	public ArrayList<ShelfPO> getShelves(String id,String keyword) throws RemoteException;
	public boolean addShelf(ShelfPO shelf) throws RemoteException;
	public boolean deleteShelf(String id) throws RemoteException;
	public boolean reviseShelf(ShelfPO shelf) throws RemoteException;
//	public ShelfPO getShelf(String id) throws RemoteException;
}
