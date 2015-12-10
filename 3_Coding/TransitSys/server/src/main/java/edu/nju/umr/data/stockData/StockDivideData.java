package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.dataService.stockDSer.StockDivideDSer;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Result;

public class StockDivideData extends UnicastRemoteObject implements StockDivideDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6752462920843759194L;
	private MysqlService mysqlSer;
	private static StockDivideData data = null;
	private StockDivideData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static StockDivideData getStockDivide() throws RemoteException{
		if(data == null){
			data = new StockDivideData();
		}
		return data;
	}

	public ArrayList<ShelfPO> getShelves(String stockId,String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = null;
		if(keyword == null){
			result = mysqlSer.checkInfo(new ShelfPO(null, stockId, 0, 0, null));
		} else {
			result = mysqlSer.checkInfo(new ShelfPO(keyword, stockId, 0, 0, null));
		}
		return ArrayListFactory.produceShelfList(result);
	}

	public Result addShelf(ShelfPO shelf) throws RemoteException {
		return mysqlSer.addInfo(shelf);
	}

	public Result deleteShelf(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.deleteInfo(new ShelfPO(id, null, 0, 0, null));
	}

	public Result reviseShelf(ShelfPO shelf) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(shelf);
	}

}
