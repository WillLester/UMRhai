package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.data.utilityData.EnumFactory;
import edu.nju.umr.dataService.workOrgManDSer.WorkManDSer;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
/*
 * 人员管理数据
 */
public class WorkManData extends UnicastRemoteObject implements WorkManDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6579757885515328662L;
	MysqlService mysqlSer;

	public WorkManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<WorkPO> findWork(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		if(keyword == null){
			return (ArrayList<WorkPO>) mysqlSer.checkAll(POKind.WORK);
		} else {
			Jurisdiction juri = EnumFactory.getJuri(keyword);
			return ArrayListFactory.produceWorkList(mysqlSer.checkInfo(new WorkPO(keyword, null, keyword, null, 0, juri, null, 0, 0)));
		}
	}

	public Result addWork(WorkPO worker) throws RemoteException {
		return mysqlSer.addInfo(worker);
	}

	public Result deleteWork(int id) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.deleteInfo(new WorkPO(null, null, null, null, id, null, null, 0, 0));
	}

	public Result reviseWork(WorkPO work) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(work);
	}

}
