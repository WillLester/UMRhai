package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.RecipientOrderDSer;

public interface RecipientOrderDFacSer extends Remote{
	public RecipientOrderDSer getRecipientOrder() throws RemoteException;
}
