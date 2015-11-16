package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.CenterLoadingPO;

public interface CenterLoadingOrderDSer extends Remote{
	public Result create(CenterLoadingPO order) throws RemoteException;
//	public ArrayList<String> getHalls() throws RemoteException;
}
