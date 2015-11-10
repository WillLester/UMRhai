package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.data.utilityData.UtilityData;
import edu.nju.umr.dataService.checkDSer.BusiCircumDSer;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.order.IncomePO;
/*
 * 经营情况表数据
 */
public class BusiCircumData extends UnicastRemoteObject implements BusiCircumDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4682435735979107069L;
	private UtilityDSer utilitySer;
	
	public BusiCircumData() throws RemoteException {
		super();
		utilitySer = new UtilityData();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<IncomePO> findCollect(Date start, Date end)
			throws RemoteException {
		// TODO 自动生成的方法存根
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
		
		return utilitySer.getHall();
	}

}
