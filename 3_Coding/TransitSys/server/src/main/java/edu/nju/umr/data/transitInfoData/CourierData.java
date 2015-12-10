package edu.nju.umr.data.transitInfoData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.OrderPOFactory;
import edu.nju.umr.dataService.transitInfoDSer.CourierDSer;
import edu.nju.umr.po.order.ExpressPO;

public class CourierData extends UnicastRemoteObject implements CourierDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -635682282196387242L;
	private MysqlService mysqlSer;
	private static CourierData data = null;
	private CourierData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static CourierData getCourierData() throws RemoteException{
		if(data == null){
			data = new CourierData();
		}
		return data;
	}

	public ExpressPO find(String barcode) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new ExpressPO(null, null, null, null, null, null, null, null, null, null, 0, 
				null, 0, 0, 0, 0, 0, barcode, null, null, null, 0, null, null, null, null, null, null, null,null));
		return OrderPOFactory.getExpress(result);
	}

}
