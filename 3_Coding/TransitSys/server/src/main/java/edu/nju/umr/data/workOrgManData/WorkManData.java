package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.workOrgManDSer.WorkManDSer;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;

public class WorkManData extends UnicastRemoteObject implements WorkManDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6579757885515328662L;
	MysqlService mysqlSer;

	public WorkManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<WorkPO> findWork(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<WorkPO> ar2=new ArrayList<WorkPO>();
		ar2.add(new WorkPO("Worker1","11111111111","1","1",Jurisdiction.ADMIN));
		ar2.add(new WorkPO("Worker2","22222222222","2","2",Jurisdiction.COURIER));
		return ar2;
	}

	public boolean addWork(WorkPO work) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteWork(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseWork(WorkPO work) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public WorkPO checkWork(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return new WorkPO("Worker1","11111111111","1","1",Jurisdiction.ADMIN);
	}

	public ArrayList<OrgPO> getOrgs() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<OrgPO> ar1=new ArrayList<OrgPO>();
		ar1.add(new OrgPO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityPO("南京","1","江苏")));
		ar1.add(new OrgPO("2","组织2",Organization.HALL,"南京大学鼓楼校区",new CityPO("南京","1","江苏")));
		return ar1;
	}

}
