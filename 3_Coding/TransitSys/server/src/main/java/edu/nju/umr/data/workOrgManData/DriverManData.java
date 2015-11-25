package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.dataService.workOrgManDSer.DriverManDSer;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.enums.Result;
/*
 * 司机信息管理数据
 */
public class DriverManData extends UnicastRemoteObject implements DriverManDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2621223833650333912L;
	MysqlService mysqlSer;

	public DriverManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public ArrayList<DriverPO> findDriver(String hallId)
			throws RemoteException {
		return ArrayListFactory.produceDriverList(mysqlSer.checkInfo(new DriverPO(null, null, null, null, null, null, null, null, hallId)));
	}
//	public ArrayList<DriverPO> driverList(){
//		return null;
//	}

	public Result addDriver(DriverPO driver) throws RemoteException {
		return mysqlSer.addInfo(driver);
	}

	public Result deleteDriver(String id) throws RemoteException {
		return mysqlSer.deleteInfo(new DriverPO(id, null, null, null, null, null, null, null,null));
	}

	public Result reviseDriver(DriverPO driver) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(driver);
	}

//	public DriverPO checkDriver(String id) throws RemoteException {
//		// TODO 自动生成的方法存根
//		return null;
//	}

}
