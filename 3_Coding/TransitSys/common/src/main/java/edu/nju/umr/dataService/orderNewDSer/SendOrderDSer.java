package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.SendPO;

public interface SendOrderDSer extends Remote{
	public Result create(SendPO order) throws RemoteException;
}
