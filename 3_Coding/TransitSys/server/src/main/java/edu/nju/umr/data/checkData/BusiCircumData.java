package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.checkDSer.BusiCircumDSer;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.order.IncomePO;

public class BusiCircumData extends UnicastRemoteObject implements BusiCircumDSer{
	
	private MysqlService mysqlSer;
	
	public BusiCircumData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<IncomePO> findCollect(Date start, Date end)
			throws RemoteException {
		// TODO 自动生成的方法存根
		@SuppressWarnings("deprecation")
		Date date = new Date(109, 4, 25);
		String express1 = "1024656";
		ArrayList<String> express = new ArrayList<String>();
		express.add(express1);
//		IncomePO income = new IncomePO(date, "宝华", 23.33, express, "00001");
		ArrayList<IncomePO> incomeList = new ArrayList<IncomePO>();
//		incomeList.add(income);
		return incomeList;
	}

	public ArrayList<OrgPO> getHall() throws RemoteException {
		// TODO 自动生成的方法存根
		CityPO city = new CityPO("北京", "010","北京");
		OrgPO org = new OrgPO("00001", "HaHa", Organization.HALL, "香港记者", city);
		ArrayList<OrgPO> orgList = new ArrayList<OrgPO>();
		orgList.add(org);
		return orgList;
	}

}
