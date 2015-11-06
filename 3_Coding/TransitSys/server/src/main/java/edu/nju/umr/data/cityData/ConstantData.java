package edu.nju.umr.data.cityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.po.ConstantPO;
import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.dataService.cityDSer.ConstantDSer;

public class ConstantData  extends UnicastRemoteObject implements ConstantDSer{
	public ConstantData () throws RemoteException
	{
		super();
	}
	
	public boolean setConstant(ConstantPO constant)throws RemoteException{
		return true;
	}
	public ConstantPO getConstant()throws RemoteException{
		return new ConstantPO(23333333,2,3,4,5,6,7,8,9);
	}

}
