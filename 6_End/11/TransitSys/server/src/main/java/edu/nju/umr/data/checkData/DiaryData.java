package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.umr.constants.DateFormat;
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
	private MysqlService mysqlSer;
	private static DiaryData data = null;
	private DiaryData() throws RemoteException {
		super();
		mysqlSer = MysqlImpl.getMysql();
		// TODO 自动生成的构造函数存根
	}
	
	public static DiaryData getDiary() throws RemoteException{
		if(data == null){
			data = new DiaryData();
		}
		return data;
	}

	public ArrayList<DiaryPO> seeDiary(Calendar start, Calendar end)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkDate(start, end, POKind.DIARY);
		ArrayList<DiaryPO> diaryList = new ArrayList<DiaryPO>();
		try {
			while(result.next()){
				Calendar time = Calendar.getInstance();
				String dateTime = result.getString(1);
				Date date = DateFormat.TIME.parse(dateTime);
				time.setTime(date);
				DiaryPO diary = new DiaryPO(result.getString(2), time, result.getString(3));
				diaryList.add(diary);
			}
		} catch (SQLException | ParseException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return diaryList;
	}
	
}
