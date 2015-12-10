package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.StockOutOrderDSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockOutPO;
/*
 * 出库单数据
 */
public class StockOutOrderData extends UnicastRemoteObject implements StockOutOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3477803137644370675L;
	private MysqlService mysqlSer;
	private static StockOutOrderData data = null;
	private StockOutOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static StockOutOrderData getStockOutOrder() throws RemoteException{
		if(data == null){
			data = new StockOutOrderData();
		}
		return data;
	}

	public Result create(StockOutPO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
	}

	@Override
	public Result removeGood(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.deleteInfo(new GoodPO(id, null, null, null, null, null, 0, 0));
	}

}
