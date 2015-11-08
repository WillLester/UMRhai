package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.workOrgManDSer.VanManDSer;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.enums.POKind;
/*
 * 车辆信息管理数据
 */
public class VanManData extends UnicastRemoteObject implements VanManDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7507578235288310599L;
	MysqlService mysqlSer;

	public VanManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<VanPO> findVan(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<VanPO> ar3=new ArrayList<VanPO>();
		ar3.add(new VanPO("1","11111",Calendar.getInstance(),null,"1"));
		ar3.add(new VanPO("2","22222",Calendar.getInstance(),null,"2"));
		return ar3;
	}

	public boolean addVan(VanPO van) throws RemoteException {
		return mysqlSer.addInfo(van, POKind.VAN);
	}

	public boolean deleteVan(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseVan(VanPO Van) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public VanPO checkVan(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return new VanPO("1","11111",Calendar.getInstance(),null,"1");
	}
	
}
