package edu.nju.umr.dataService.orderNewDSer;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.PaymentPO;

public interface PaymentOrderDSer extends Remote{
	public Result create(PaymentPO order) throws RemoteException;
	public Result updateAccount(String account,BigDecimal amount) throws RemoteException;
}
