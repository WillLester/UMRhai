package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.checkDSer.StatementSheetDSer;

public interface StatementSheetDFacSer extends Remote{
	public StatementSheetDSer getStatementSheet() throws RemoteException;
}
