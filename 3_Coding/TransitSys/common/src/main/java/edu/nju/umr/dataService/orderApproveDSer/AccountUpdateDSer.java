package edu.nju.umr.dataService.orderApproveDSer;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.enums.Result;

public interface AccountUpdateDSer extends Remote{
	public Result income(String account,BigDecimal amount) throws RemoteException;
	public Result pay(String account,BigDecimal amount) throws RemoteException;
}
