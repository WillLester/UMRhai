package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.dataService.orderNewDSer.StockInOrderDSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockInPO;
/*
 * 入库单数据
 */
public class StockInOrderData extends UnicastRemoteObject implements StockInOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1208410511647254989L;
	private MysqlService mysqlSer;
	public StockInOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}

	public Result create(StockInPO order) throws RemoteException {
		return mysqlSer.addInfo(order);
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

}
