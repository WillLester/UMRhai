package edu.nju.umr.data.workOrgManData;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.workOrgManDSer.OrgManDSer;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.enums.Organization;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class OrgManData extends UnicastRemoteObject implements OrgManDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6797725942565577714L;
	MysqlService mysqlSer;

	public OrgManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<OrgPO> findOrg(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<OrgPO> ar1=new ArrayList<OrgPO>();
		ar1.add(new OrgPO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityPO("南京","025","江苏")));
		ar1.add(new OrgPO("2","组织2",Organization.HALL,"南京大学鼓楼校区",new CityPO("南京","025","江苏")));
		return ar1;
	}

	public boolean addOrg(OrgPO org) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteOrg(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseOrg(OrgPO org) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

//	public OrgPO checkOrg(String id) throws RemoteException {
//		// TODO 自动生成的方法存根
//
//		return new OrgPO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityPO("南京","1"));
//	}

	public ArrayList<CityPO> getCities() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<CityPO> ar=new ArrayList<CityPO>();
		ar.add(new CityPO("南京","1","江苏"));
		ar.add(new CityPO("北京","2","北京"));
		return ar;
	}

}
