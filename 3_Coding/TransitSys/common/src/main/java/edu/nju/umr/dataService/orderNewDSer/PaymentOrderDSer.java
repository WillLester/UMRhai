package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.RemoteException;

import edu.nju.umr.po.order.PaymentPO;

public interface PaymentOrderDSer {
	public boolean create(PaymentPO order) throws RemoteException;
}
