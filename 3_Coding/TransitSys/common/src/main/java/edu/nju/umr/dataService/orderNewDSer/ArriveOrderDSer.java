package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ArrivePO;

public interface ArriveOrderDSer extends Remote{
	public Result create(ArrivePO order) throws RemoteException;
	public ArrayList<String> getExpressList(String id) throws RemoteException;//拿到单号为id的中转单的快递组
}
