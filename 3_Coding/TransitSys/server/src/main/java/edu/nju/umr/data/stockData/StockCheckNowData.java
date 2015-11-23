package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.stockDSer.StockCheckNowDSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.enums.Part;

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
		ArrayList<GoodPO> goodList = new ArrayList<GoodPO>();
		Part parts[] = Part.values();
		try {
			while(result.next()){
				Calendar date = Calendar.getInstance();
				date.setTime(result.getDate(7));
				GoodPO good = new GoodPO(result.getString(0), result.getString(1), date, result.getString(2), parts[result.getInt(3)], result.getString(4), result.getInt(5), result.getInt(6));
				goodList.add(good);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		StockPO stock = new StockPO(id, goodList);
		return stock;
	}
}
