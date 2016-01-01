package edu.nju.umr.data.orderApproveData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderApproveDSer.GoodUpdateDSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.enums.Result;

public class GoodUpdateData extends UnicastRemoteObject implements GoodUpdateDSer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4958821286453424369L;
	private static MysqlService mysqlSer;
	private static GoodUpdateData data = null;

	private GoodUpdateData() throws RemoteException {
		super();
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static GoodUpdateData getGoodUpdate() throws RemoteException{
		if(data == null){
			data = new GoodUpdateData();
		}
		return data;
	}

	@Override
	public Result addGood(GoodPO good) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.addInfo(good);
	}

	@Override
	public Result removeGood(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.deleteInfo(new GoodPO(id, null, null, null, null, null, 0, 0));
	}

}
