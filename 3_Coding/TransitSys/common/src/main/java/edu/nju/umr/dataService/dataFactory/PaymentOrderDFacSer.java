package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.PaymentOrderDSer;

public interface PaymentOrderDFacSer extends Remote{
	public PaymentOrderDSer getPaymentOrder() throws RemoteException;
}
