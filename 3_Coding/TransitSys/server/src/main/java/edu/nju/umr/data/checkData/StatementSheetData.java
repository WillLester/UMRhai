package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.dataService.checkDSer.StatementSheetDSer;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.order.IncomePO;

public class StatementSheetData extends UnicastRemoteObject implements StatementSheetDSer{

	protected StatementSheetData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<IncomePO> getCollectRec(Date date, String id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<OrgPO> getHall() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
