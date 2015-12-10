package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.HallLoadingPO;
/*
 * 营业厅装车单数据
 */
public class HallLoadingOrderData extends UnicastRemoteObject implements HallLoadingOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6768962889030917613L;
	private MysqlService mysqlSer;
	private static HallLoadingOrderData data = null;
	private HallLoadingOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static HallLoadingOrderData getHallLoading() throws RemoteException{
		if(data == null){
			data = new HallLoadingOrderData();
		}
		return data;
	}

	public Result create(HallLoadingPO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
		
	}

}
