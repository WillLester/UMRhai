package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.data.utilityData.OrderCounter;
import edu.nju.umr.dataService.orderNewDSer.StockInOrderDSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.function.GetToday;
/*
 * 入库单数据
 */
public class StockInOrderData extends UnicastRemoteObject implements StockInOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1208410511647254989L;
	private MysqlService mysqlSer;
	private static StockInOrderData data = null;
	private StockInOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static StockInOrderData getStockInOrder() throws RemoteException{
		if(data == null){
			 data = new StockInOrderData();
		}
		return data;
	}

	public Result create(StockInPO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
	}

	@Override
	public ArrayList<ShelfPO> getShelves(String orgId) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new ShelfPO(null, orgId, 0, 0, null));
		return ArrayListFactory.produceShelfList(result);
	}

	@Override
	public Result addGood(GoodPO good) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.addInfo(good);
	}

	@Override
	public int getOrderSize(String partId) throws RemoteException {
		// TODO 自动生成的方法存根
		GetToday get = new StockInPO(partId, null, null, null, null, null, 0, 0, null, null, null, null);
		ResultSet result = mysqlSer.checkToday(get);
		return OrderCounter.count(result);
	}

}
