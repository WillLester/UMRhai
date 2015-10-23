package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.dataService.checkDSer.DiaryDSer;
import edu.nju.umr.po.DiaryPO;

public class DiaryData extends UnicastRemoteObject implements DiaryDSer{

	protected DiaryData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<DiaryPO> seeDiary(Date start, Date end)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
