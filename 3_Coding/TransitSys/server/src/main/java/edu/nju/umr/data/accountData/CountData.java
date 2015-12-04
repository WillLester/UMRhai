package edu.nju.umr.data.accountData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.SerialHelper;
import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.enums.Result;
/*
 * 账数据
 */
public class CountData extends UnicastRemoteObject implements CountDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3199440496716511453L;
	public CountData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Result addCount(CountPO count) throws RemoteException {
		return SerialHelper.writeToFile(count, "data/count.ser");
		
	}

	public CountPO findInitInfo(int id) throws RemoteException {
		// TODO 自动生成的方法存根
		return (CountPO) SerialHelper.readFromFile("data/count"+id+".ser");
	}
	public ArrayList<CountPO> getCount() throws RemoteException {
		return null;
	}

	@Override
	public Result deleteCount(int id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
