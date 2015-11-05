package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.dataService.checkDSer.DiaryDSer;
import edu.nju.umr.po.DiaryPO;

public class DiaryData extends UnicastRemoteObject implements DiaryDSer{

	public DiaryData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<DiaryPO> seeDiary(Date start, Date end)
			throws RemoteException {
		// TODO 自动生成的方法存根
		@SuppressWarnings("deprecation")
		Date date = new Date(109, 4, 25,11,24,30);
		DiaryPO diary = new DiaryPO("生成快递单", date,"华莱士餐厅");
		ArrayList<DiaryPO> diaryList = new ArrayList<DiaryPO>();
		diaryList.add(diary);
		return diaryList;
	}
	
}
