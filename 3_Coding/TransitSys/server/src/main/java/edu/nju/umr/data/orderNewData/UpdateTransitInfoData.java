package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.UpdateTransitInfoDSer;

public class UpdateTransitInfoData extends UnicastRemoteObject implements UpdateTransitInfoDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1467130296766277284L;
	private MysqlService mysqlSer;
	public UpdateTransitInfoData()throws RemoteException{
		super();
		mysqlSer = new MysqlImpl();
	}
	public boolean update(String id,String info) throws RemoteException{		
		return true;
	}

}
