package edu.nju.umr.data.transitInfoData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.transitInfoDSer.CourierDSer;
import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.order.ExpressPO;

public class CourierData extends UnicastRemoteObject implements CourierDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -635682282196387242L;
	MysqlService mysqlSer;

	public CourierData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public ExpressPO find(String barcode) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new ExpressPO(null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 0, 0, 0, barcode, null, null, 0, null, null));
		Express expresses[] = Express.values();
		ExpressPO express = null;
		try {
			if(result.next()){
				Calendar arrive = Calendar.getInstance();
				arrive.setTime(result.getDate(17));
				Calendar opTime = Calendar.getInstance();
				opTime.setTime(result.getDate(22));
				express = new ExpressPO(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getString(8), result.getString(9), result.getString(10), result.getInt(11), result.getString(12), result.getDouble(13), result.getDouble(14), result.getDouble(15), result.getDouble(24), result.getDouble(16), result.getString(0), arrive, expresses[result.getInt(18)], result.getDouble(19), opTime, result.getString(23));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return express;
	}

}
