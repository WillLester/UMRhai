package edu.nju.umr.dataService.orderApproveDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.order.OrderPO;

public interface OrderApproveDSer extends Remote{
	public ArrayList<OrderPO> getExamine() throws RemoteException;
	public boolean update(boolean isPassed,ArrayList<String> id) throws RemoteException;
	public Object getOrder(String id) throws RemoteException;
}
