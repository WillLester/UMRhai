package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.stockDSer.StockCheckDSer;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;

public class StockCheckData extends UnicastRemoteObject implements StockCheckDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4838689550105494049L;
	private MysqlService mysqlSer;
	private static StockCheckData data  = null;
	private StockCheckData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static StockCheckData getStockCheck() throws RemoteException{
		if(data == null){
			data = new StockCheckData();
		}
		return data;
	}

	public ArrayList<StockInPO> getIn(Calendar start, Calendar end, String id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkDate(start, end, POKind.STOCKIN);
		ArrayList<StockInPO> stockInList = new ArrayList<StockInPO>();
		Part parts[] = Part.values();
		try {
			while(result.next()){
				if(result.getString(11).equals(id)){
					Calendar date = Calendar.getInstance();
					date.setTime(result.getDate(8));
					Calendar opTime = Calendar.getInstance();
					opTime.setTime(result.getDate(10));
					StockInPO stockIn = new StockInPO(result.getString(1), result.getString(2), date, result.getString(3),
							parts[result.getInt(4)], result.getString(5), result.getInt(6), result.getInt(7), opTime, 
							result.getString(10), result.getString(11),result.getString(12));
					stockInList.add(stockIn);
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return stockInList;
	}

	public ArrayList<StockOutPO> getOut(Calendar start, Calendar end, String id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkDate(start, end, POKind.STOCKOUT);
		ArrayList<StockOutPO> stockOutList = new ArrayList<StockOutPO>();
		Transit transits[] = Transit.values();
		try {
			while(result.next()){
				if(result.getString(7).equals(id)){
					Calendar date = Calendar.getInstance();
					date.setTime(result.getDate(5));
					Calendar opTime = Calendar.getInstance();
					opTime.setTime(result.getDate(6));
					StockOutPO stockOut = new StockOutPO(result.getString(1), result.getString(2), date, transits[result.getInt(3)], 
							result.getString(9),result.getString(4), opTime, result.getString(8), result.getString(9),result.getString(10));
					stockOutList.add(stockOut);
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return stockOutList;
	}

}
