package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.OrderPOFactory;
import edu.nju.umr.dataService.orderNewDSer.RecipientOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.po.order.TransitPO;
/*
 * 接收单数据
 */
public class RecipientOrderData extends UnicastRemoteObject implements RecipientOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 134682087211527556L;
	private MysqlService mysqlSer;
	public RecipientOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public Result create(RecipientPO order) throws RemoteException {
		return mysqlSer.addInfo(order);
	}

	@Override
	public ArrayList<String> getExpressList(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new TransitPO(id, null, null, null, null, null, null, null, null, null, 0, null));
		TransitPO transit = OrderPOFactory.getTransit(result);
		return transit.getExpress();
	}

}
