package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.OrderInfoData;
import edu.nju.umr.dataService.orderNewDSer.RecipientOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.RecipientPO;
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
		mysqlSer = MysqlImpl.getMysql();
	}

	public Result create(RecipientPO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
	}

	@Override
	public ArrayList<String> getExpressList(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return OrderInfoData.getExpressList(id);
	}

}
