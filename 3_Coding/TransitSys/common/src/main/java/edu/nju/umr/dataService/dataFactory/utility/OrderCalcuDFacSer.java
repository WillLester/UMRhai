package edu.nju.umr.dataService.dataFactory.utility;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.OrderCalcuDSer;

public interface OrderCalcuDFacSer extends Remote{
	public OrderCalcuDSer getOrderCalcu() throws RemoteException;
}
