package edu.nju.umr.dataService.orderApproveDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.ConstantPO;

public interface ConstantGetDSer extends Remote{
	/**
	 * 获得常量
	 * @return 常量PO
	 * @throws RemoteException
	 */
	public ConstantPO getConstant() throws RemoteException;
}
