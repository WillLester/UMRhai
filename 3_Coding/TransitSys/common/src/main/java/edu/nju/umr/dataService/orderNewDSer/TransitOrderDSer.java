package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.TransitPO;

public interface TransitOrderDSer extends Remote{
	public Result create(TransitPO order) throws RemoteException;
	public ArrayList<String> getCities() throws RemoteException;
}
