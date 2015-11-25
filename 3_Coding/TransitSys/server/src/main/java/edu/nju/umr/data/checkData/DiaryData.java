package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.checkDSer.DiaryDSer;
import edu.nju.umr.po.DiaryPO;
import edu.nju.umr.po.enums.POKind;
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

	public ArrayList<DiaryPO> seeDiary(Calendar start, Calendar end)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkDate(start, end, POKind.DIARY);
		ArrayList<DiaryPO> diaryList = new ArrayList<DiaryPO>();
		try {
			while(result.next()){
				Calendar time = Calendar.getInstance();
				time.setTime(result.getDate(1));
				DiaryPO diary = new DiaryPO(result.getString(2), time, result.getString(3));
				diaryList.add(diary);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return diaryList;
	}
	
}
