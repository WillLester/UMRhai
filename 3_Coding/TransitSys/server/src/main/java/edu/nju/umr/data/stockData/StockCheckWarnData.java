package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.databaseUtility.SerialHelper;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.dataService.stockDSer.StockCheckWarnDSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.StockPO;

public class StockCheckWarnData extends UnicastRemoteObject implements StockCheckWarnDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2620162538190055811L;
	private static StockCheckWarnData data = null;
	private MysqlService mysqlSer;
	private StockCheckWarnData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static StockCheckWarnData getStockCheckWarn() throws RemoteException{
		if(data == null){
			data = new StockCheckWarnData();
		}
		return data;
	}

	public ArrayList<Integer> getWarning(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		@SuppressWarnings("unchecked")
		ArrayList<Integer> warnings = (ArrayList<Integer>) SerialHelper.readFromFile("data/stockWarning/"+id+".ser");
		return warnings;
	}

	public StockPO getStock(String stockId) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new GoodPO(null, stockId, null, null, null, null, 0, 0));
		ArrayList<GoodPO> goods = ArrayListFactory.produceGoodList(result);
		StockPO stock = new StockPO(stockId, goods);
		return stock;
	}

	public ArrayList<ShelfPO> getShelves(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new ShelfPO(null, id, 0, 0, null));
		ArrayList<ShelfPO> ar = ArrayListFactory.produceShelfList(result);
		return ar;
	}

}
