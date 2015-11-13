package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.UpdateTransitInfoDSer;
import edu.nju.umr.po.TransitInfoPO;
import edu.nju.umr.po.enums.POKind;

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
	public boolean update(TransitInfoPO info) throws RemoteException{		
		return mysqlSer.reviseInfo(info, POKind.TRANSITINFO);
	}
	public boolean addInfo(TransitInfoPO info) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.addInfo(info, POKind.TRANSITINFO);
	}

}
