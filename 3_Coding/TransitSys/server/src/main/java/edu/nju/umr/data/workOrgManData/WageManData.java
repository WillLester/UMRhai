package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.dataService.workOrgManDSer.WageManDSer;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.utility.EnumTransFactory;

public class WageManData extends UnicastRemoteObject implements WageManDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2101834215561188546L;
	private MysqlService mysqlSer;
	public WageManData() throws RemoteException {
		super();
		mysqlSer = MysqlImpl.getMysql();
		// TODO 自动生成的构造函数存根
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkPO> searchWork(String keyword) throws RemoteException{
		// TODO 自动生成的方法存根
		if(keyword == null){
			return (ArrayList<WorkPO>) mysqlSer.checkAll(POKind.WORK);
		} else {
			Jurisdiction juri = EnumTransFactory.getJuri(keyword);
			return ArrayListFactory.produceWorkList(mysqlSer.checkInfo(new WorkPO(keyword, null, keyword, null, 0, juri, null, 0, 0)));
		}
	}

	@Override
	public Result updateWork(WorkPO work) throws RemoteException{
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(work);
	}

}
