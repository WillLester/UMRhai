package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.CenterLoadingPO;

public interface CenterLoadingOrderDSer extends Remote{
	public Result create(CenterLoadingPO order) throws RemoteException;
}
