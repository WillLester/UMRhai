package edu.nju.umr.dataService.dataFactory.check;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.checkDSer.CostBeneDSer;

public interface CostBeneDFacSer extends Remote{
	public CostBeneDSer getCostBene() throws RemoteException;
}
