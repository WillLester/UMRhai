package edu.nju.umr.dataService.dataFactory.orderNew;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.IncomeOrderDSer;

public interface IncomeOrderDFacSer extends Remote{
	public IncomeOrderDSer getIncomeOrder() throws RemoteException;
}
