package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.HallLoadingPO;

public interface HallLoadingOrderDSer extends Remote{
	public Result create(HallLoadingPO order) throws RemoteException;
//	public ArrayList<String> getOrgs() throws RemoteException;
//	public ArrayList<String> getVans() throws RemoteException;
}
