package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.cityDSer.ConstantDSer;

public interface ConstantDFacSer extends Remote{
	public ConstantDSer getConstant() throws RemoteException;

}
