package edu.nju.umr.data.transitInfoData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.transitInfoDSer.CustomerDSer;

public class CustomerData extends UnicastRemoteObject implements CustomerDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1090030972122587470L;
	MysqlService mysqlSer;

	public CustomerData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<String> findTransit(String barcode) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<String> ar=new ArrayList<String>();
		ar.add("您的包裹已经起飞");
		ar.add("您的包裹已经降落");
		return ar;
	}

}
