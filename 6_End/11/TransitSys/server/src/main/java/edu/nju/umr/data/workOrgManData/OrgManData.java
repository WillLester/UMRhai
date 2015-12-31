package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.dataService.workOrgManDSer.OrgManDSer;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.utility.EnumTransFactory;
/*
 * 机构信息管理数据
 */
public class OrgManData extends UnicastRemoteObject implements OrgManDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6797725942565577714L;
	private MysqlService mysqlSer;
	private static OrgManData data = null;
	private OrgManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static OrgManData getOrgMan() throws RemoteException{
		if(data == null){
			data = new OrgManData();
		}
		return data;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<OrgPO> findOrg(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		if(keyword == null){
			return (ArrayList<OrgPO>) mysqlSer.checkAll(POKind.ORG);
		} else {
			Organization kind = EnumTransFactory.getOrg(keyword);
			return ArrayListFactory.produceOrgList(mysqlSer.checkInfo(new OrgPO(keyword, keyword, kind, null, keyword, null)));
		}
		
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

}
