package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.dataService.stockDSer.StockCheckNowDSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.StockPO;

public class StockCheckNowData extends UnicastRemoteObject implements StockCheckNowDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6212234457642125928L;
	MysqlService mysqlSer;

	public StockCheckNowData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public StockPO getStock(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new GoodPO(null, id, null, null, null, null, 0, 0));
		ArrayList<GoodPO> goodList = ArrayListFactory.produceGoodList(result);
		StockPO stock = new StockPO(id, goodList);
		return stock;
	}
}
