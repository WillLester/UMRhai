package edu.nju.umr.data.accountData;

import java.io.File;
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
	private static final String LOCATION = "data/count";
	public CountData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Result addCount(CountPO count) throws RemoteException {
		int num = countCount();
		return SerialHelper.writeToFile(count, LOCATION+"/count"+num+".ser");
		
	}

	public ArrayList<CountPO> getCount() throws RemoteException {
		ArrayList<CountPO> countList = new ArrayList<CountPO>();
		for(int i = 0;i < countCount();i++){
			CountPO count = (CountPO) SerialHelper.readFromFile(LOCATION+"/count"+i+".ser");
			countList.add(count);
		}
		return countList;
	}

	@Override
	public Result deleteCount(int id) throws RemoteException {
		// TODO 自动生成的方法存根
		File file = new File(LOCATION+"/count"+id+".ser");
		boolean isSuc = file.delete();
		if(isSuc){
			return Result.SUCCESS;
		} else {
			return Result.FILE_NOT_FOUND;
		}
	}

	private int countCount(){
		File file = new File(LOCATION);
		File[] fs = file.listFiles();
		return fs.length;
	}
	
}
