package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.CenterLoadingOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.CenterLoadingPO;
/*
 * 中转中心装车单数据
 */
public class CenterLoadingOrderData extends UnicastRemoteObject implements CenterLoadingOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5859251989231665786L;
	private MysqlService mysqlSer;
	private static CenterLoadingOrderData data = null;
	private CenterLoadingOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static CenterLoadingOrderData getCenterLoading() throws RemoteException{
		if(data == null){
			data = new CenterLoadingOrderData();
		}
		return data;
	}

	public Result create(CenterLoadingPO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
		
	}

}
