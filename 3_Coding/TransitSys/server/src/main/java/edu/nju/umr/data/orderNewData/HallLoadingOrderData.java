package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.HallLoadingPO;
/*
 * 营业厅装车单数据
 */
public class HallLoadingOrderData extends UnicastRemoteObject implements HallLoadingOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6768962889030917613L;
	private MysqlService mysqlSer;
	public HallLoadingOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public Result create(HallLoadingPO order) throws RemoteException {
		return mysqlSer.addInfo(order);
		
	}

}
