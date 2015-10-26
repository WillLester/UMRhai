package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.RemoteException;
import java.rmi.Remote;

import edu.nju.umr.po.order.PaymentPO;

public interface PaymentOrderDSer extends Remote{
	public boolean create(PaymentPO order) throws RemoteException;
}
