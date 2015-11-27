package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ExpressPO;

public interface ReceiveOrderDSer extends Remote {
	public Result create(ExpressPO order) throws RemoteException;
}
