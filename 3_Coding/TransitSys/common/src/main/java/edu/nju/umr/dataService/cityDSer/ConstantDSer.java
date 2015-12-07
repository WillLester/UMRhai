package edu.nju.umr.dataService.cityDSer;
import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.ConstantPO;
import edu.nju.umr.po.enums.Result;

public interface ConstantDSer extends Remote{
	public Result setConstant(ConstantPO constant)throws RemoteException;
	public ConstantPO getConstant() throws RemoteException;
}
