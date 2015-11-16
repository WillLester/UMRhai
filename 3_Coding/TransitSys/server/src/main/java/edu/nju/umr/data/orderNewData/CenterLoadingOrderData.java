package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.CenterLoadingOrderDSer;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.CenterLoadingPO;
/*
 * 中转中心装车单数据
 */
public class CenterLoadingOrderData extends UnicastRemoteObject implements CenterLoadingOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5859251989231665786L;
	private MysqlService mysqlSer;
	public CenterLoadingOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public Result create(CenterLoadingPO order) throws RemoteException {
		return mysqlSer.addInfo(order, POKind.CENTERLOADING);
		
	}

//	public ArrayList<String> getHalls() throws RemoteException {
//		String hall1 = "逸夫楼";
//		String hall2 = "商学院";
//		ArrayList<String> halls = new ArrayList<String>();
//		halls.add(hall1);
//		halls.add(hall2);
//		return halls;
//	}

}
