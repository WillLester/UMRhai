package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.checkDSer.DiaryDSer;
import edu.nju.umr.po.DiaryPO;
/*
 * 查看日志数据
 */
public class DiaryData extends UnicastRemoteObject implements DiaryDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7861281030978291919L;
	MysqlService mysqlSer;
	public DiaryData() throws RemoteException {
		super();
		mysqlSer = new MysqlImpl();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<DiaryPO> seeDiary(Date start, Date end)
			throws RemoteException {
		// TODO 自动生成的方法存根
		DiaryPO diary = new DiaryPO("生成快递单", Calendar.getInstance(),"华莱士餐厅");
		ArrayList<DiaryPO> diaryList = new ArrayList<DiaryPO>();
		diaryList.add(diary);
		return diaryList;
	}
	
}
