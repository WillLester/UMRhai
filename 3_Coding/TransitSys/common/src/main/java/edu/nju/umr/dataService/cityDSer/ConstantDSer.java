package edu.nju.umr.dataService.cityDSer;
import edu.nju.umr.po.ConstantPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConstantDSer extends Remote{
	public boolean setConstant(ConstantPO constant)throws RemoteException;
	public ConstantPO getConstant()throws RemoteException;
}
