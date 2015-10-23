package edu.nju.umr.data.accountData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.po.CountPO;

public class CountData extends UnicastRemoteObject implements CountDSer{

	protected CountData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean addCount(CountPO count) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public CountPO findInitInfo() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
