package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.CenterLoadingOrderDSer;
import edu.nju.umr.po.order.CenterLoadingPO;

public class CenterLoadingOrderData extends UnicastRemoteObject implements CenterLoadingOrderDSer{
	private MysqlService mysqlSer;
	public CenterLoadingOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(CenterLoadingPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public ArrayList<String> getHalls() throws RemoteException {
		// TODO 自动生成的方法存根
		String hall1 = "逸夫楼";
		String hall2 = "商学院";
		ArrayList<String> halls = new ArrayList<String>();
		halls.add(hall1);
		halls.add(hall2);
		return halls;
	}

}
