package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.workOrgManDSer.OrgManDSer;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Result;
/*
 * 机构信息管理数据
 */
public class OrgManData extends UnicastRemoteObject implements OrgManDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6797725942565577714L;
	MysqlService mysqlSer;

	public OrgManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public ArrayList<OrgPO> findOrg(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<OrgPO> ar1=new ArrayList<OrgPO>();
		ar1.add(new OrgPO("1","组织1",Organization.CENTER,"南京大学仙林校区","南京","025"));
		ar1.add(new OrgPO("2","组织2",Organization.HALL,"南京大学鼓楼校区","南京","025"));
		return ar1;
	}

	public Result addOrg(OrgPO org) throws RemoteException {
		return mysqlSer.addInfo(org);
	}

	public Result deleteOrg(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.deleteInfo(new OrgPO(id, null, null, null, null,null));
	}

	public Result reviseOrg(OrgPO org) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(org);
	}

//	public OrgPO checkOrg(String id) throws RemoteException {
//		// TODO 自动生成的方法存根
//
//		return new OrgPO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityPO("南京","1"));
//	}

//	public ArrayList<CityPO> getCities() throws RemoteException {
//		// TODO 自动生成的方法存根
//		ArrayList<CityPO> ar=new ArrayList<CityPO>();
//		ar.add(new CityPO("南京","1","江苏"));
//		ar.add(new CityPO("北京","2","北京"));
//		return ar;
//	}

}
