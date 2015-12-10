package edu.nju.umr.data.utilityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.utilityDSer.DiaryUpdateDSer;
import edu.nju.umr.po.DiaryPO;
import edu.nju.umr.po.enums.Result;

public class DiaryUpdateData extends UnicastRemoteObject implements DiaryUpdateDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 769194790406389367L;
	private MysqlService mysqlSer;
	private static DiaryUpdateData data = null;
	private DiaryUpdateData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static DiaryUpdateData getDiaryUpdate() throws RemoteException{
		if(data == null){
			data = new DiaryUpdateData();
		}
		return data;
	}

	@Override
	public Result addDiary(DiaryPO diary) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.addInfo(diary);
	}

}
