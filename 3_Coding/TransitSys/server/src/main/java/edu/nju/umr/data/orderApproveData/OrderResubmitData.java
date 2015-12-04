package edu.nju.umr.data.orderApproveData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.OrderListFactory;
import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;
import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.po.order.KindGetter;
/*
 * 订单重提交
 */
public class OrderResubmitData extends UnicastRemoteObject implements OrderResubmitDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5947380830581319837L;
	MysqlService mysqlSer;

	public OrderResubmitData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public ArrayList<KindGetter> getOrders(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<KindGetter> ordersUnpassed = new ArrayList<KindGetter>();
		
		return null;
	}
	
	private ArrayList<KindGetter> getArrive(String id){
		ResultSet re = mysqlSer.checkUnpassed(new ArrivePO(null, null, null, null, null, null, null, id));
		if(!isNull(re)){
			return OrderListFactory.produceArrive(re);
		} else {
			return null;
		}
	}
	
	private boolean isNull(ResultSet result){
		if(result == null){
			return true;
		} else{
			return false;
		}
	}

}
