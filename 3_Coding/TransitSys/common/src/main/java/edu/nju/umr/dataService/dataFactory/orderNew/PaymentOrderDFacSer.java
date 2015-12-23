package edu.nju.umr.dataService.dataFactory.orderNew;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.PaymentOrderDSer;

public interface PaymentOrderDFacSer extends Remote{
	public PaymentOrderDSer getPaymentOrder() throws RemoteException;
}
