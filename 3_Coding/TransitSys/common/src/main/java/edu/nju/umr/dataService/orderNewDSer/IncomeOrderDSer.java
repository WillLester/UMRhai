package edu.nju.umr.dataService.orderNewDSer;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.IncomePO;

public interface IncomeOrderDSer extends Remote{
	public Result create(IncomePO order) throws RemoteException;
	public Result updateAccount(String account,BigDecimal amount) throws RemoteException;
}
