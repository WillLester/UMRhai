package edu.nju.umr.dataService.orderApproveDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.OrderPO;

public interface OrderApproveDSer extends Remote{
	public ArrayList<OrderPO> getExamine() throws RemoteException;
	public Result update(boolean isPassed,ArrayList<String> id,Order kind) throws RemoteException;
	public PO getOrder(String id,Order kind) throws RemoteException;
}
