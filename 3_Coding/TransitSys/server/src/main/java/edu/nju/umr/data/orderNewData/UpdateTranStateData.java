package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.UpdateTranStateDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.function.LocationFind;
import edu.nju.umr.po.order.function.UpdateTranState;

public class UpdateTranStateData extends UnicastRemoteObject implements UpdateTranStateDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5389478197014573163L;
	private MysqlService mysqlSer;
	private static UpdateTranStateData data = null;

	private UpdateTranStateData() throws RemoteException {
		super();
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static UpdateTranStateData getUpdateTranState() throws RemoteException{
		if(data == null){
			data = new UpdateTranStateData();
		}
		return data;
	}

	@Override
	public Result updateTranState(UpdateTranState order) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.updateTranState(order);
	}

	@Override
	public List<String> getExpressesHere(LocationFind order)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.getOrdersHere(order);
		List<String> expresses = new ArrayList<String>();
		try {
			while(result.next()){
				expresses.add(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return new ArrayList<String>();
		}
		return expresses;
	}

}
