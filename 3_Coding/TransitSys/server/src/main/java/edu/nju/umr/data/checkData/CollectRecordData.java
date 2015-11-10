package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.UtilityData;
import edu.nju.umr.dataService.checkDSer.CollectRecordDSer;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.order.IncomePO;
/*
 * 收款记录数据
 */
public class CollectRecordData extends UnicastRemoteObject implements CollectRecordDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2546029703937491602L;
	private MysqlService mysqlSer;
	private UtilityDSer utilitySer;
	public CollectRecordData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
		utilitySer = new UtilityData();
	}

	public ArrayList<IncomePO> getCollectRec(Date date, String id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		String express1 = "1024656";
		ArrayList<String> express = new ArrayList<String>();
		express.add(express1);
//		IncomePO income = new IncomePO(date, "宝华", 23.33, express, id);
		ArrayList<IncomePO> incomeList = new ArrayList<IncomePO>();
//		incomeList.add(income);
		return incomeList;
	}
	public ArrayList<OrgPO> getHall() throws RemoteException{

		return 	utilitySer.getHall();
	}

	

}
