package edu.nju.umr.data.transitInfoData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.transitInfoDSer.CustomerDSer;
import edu.nju.umr.po.TransitInfoPO;

public class CustomerData extends UnicastRemoteObject implements CustomerDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1090030972122587470L;
	MysqlService mysqlSer;

	public CustomerData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public ArrayList<String> findTransit(String barcode) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new TransitInfoPO(barcode, null));
		ArrayList<String> info = new ArrayList<String>();
		try {
			if(result.next()){
				String text = result.getString(2);
				String infos[] = text.split(" ");
				for(int i = 0;i < infos.length;i++){
					info.add(infos[i]);
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return info;
	}

}
