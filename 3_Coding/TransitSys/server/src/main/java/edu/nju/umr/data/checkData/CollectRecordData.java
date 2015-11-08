package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.checkDSer.CollectRecordDSer;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.order.IncomePO;

public class CollectRecordData extends UnicastRemoteObject implements CollectRecordDSer{
	MysqlService mysqlSer;
	public CollectRecordData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
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
	public ArrayList<OrgPO> getHall()
			throws RemoteException{
		return null;
	}

	

}
