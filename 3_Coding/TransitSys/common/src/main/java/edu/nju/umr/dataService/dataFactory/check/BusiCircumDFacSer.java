package edu.nju.umr.dataService.dataFactory.check;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.checkDSer.BusiCircumDSer;

public interface BusiCircumDFacSer extends Remote{
	public BusiCircumDSer getStatement() throws RemoteException;
}
