package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.checkDSer.BusiCircumDSer;

public interface StatementSheetDFacSer extends Remote{
	public BusiCircumDSer getStatement() throws RemoteException;
}
