package edu.nju.umr.dataService.orderApproveDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.TransitInfoPO;
import edu.nju.umr.po.enums.Result;

public interface UpdateTransitInfoDSer extends Remote{
	public Result addInfo(TransitInfoPO info) throws RemoteException;
	public Result update(TransitInfoPO info) throws RemoteException;
}
