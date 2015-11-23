package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.stockDSer.StockDivideDSer;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;

public class StockDivideData extends UnicastRemoteObject implements StockDivideDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6752462920843759194L;
	private MysqlService mysqlSer;
	public StockDivideData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public ArrayList<ShelfPO> getShelves(String stockId,String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = null;
		if(keyword == null){
			result = mysqlSer.checkInfo(new ShelfPO(null, stockId, 0, 0, null));
		} else {
			result = mysqlSer.checkInfo(new ShelfPO(keyword, stockId, 0, 0, null));
		}
		ArrayList<ShelfPO> shelfList = new ArrayList<ShelfPO>();
		Part parts[] = Part.values();
		try {
			while(result.next()){
				ShelfPO shelf = new ShelfPO(result.getString(0), result.getString(1), result.getInt(2), result.getInt(3), parts[result.getInt(4)]);
				shelfList.add(shelf);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return shelfList;
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

//	public ShelfPO getShelf(String id) throws RemoteException {
//		// TODO 自动生成的方法存根
//		return new ShelfPO("2",3,4,Part.TRAIN);
//		//return null;
//	}

}
