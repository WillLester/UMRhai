package edu.nju.umr.dataService.accountDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.CountPO;

public interface CountDSer extends Remote{
	public boolean addCount(CountPO count) throws RemoteException;
	public CountPO findInitInfo() throws RemoteException;
}
