package edu.nju.umr.dataService.dataFactory.check;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.checkDSer.IncomeListDSer;

public interface IncomeListDFacSer extends Remote{
	public IncomeListDSer getIncomeList() throws RemoteException;
}
