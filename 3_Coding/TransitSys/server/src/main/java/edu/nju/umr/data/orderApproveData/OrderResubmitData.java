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
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.po.order.TransitPO;
import edu.nju.umr.po.order.function.KindGetter;
import edu.nju.umr.po.order.function.OrderOper;
/*
 * 订单重提交
 */
public class OrderResubmitData extends UnicastRemoteObject implements OrderResubmitDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5947380830581319837L;
	private MysqlService mysqlSer;
	private static OrderResubmitData data = null;
	private OrderResubmitData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}

	public static OrderResubmitData getOrderResubmit() throws RemoteException{
		if(data == null){
			data = new OrderResubmitData();
		}
		return data;
	}

	public ArrayList<KindGetter> getOrders(String userId) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<KindGetter> ordersUnpassed = new ArrayList<KindGetter>();
		ordersUnpassed.addAll(getArrive(userId));
		ordersUnpassed.addAll(getCenterLoad(userId));
		ordersUnpassed.addAll(getExpress(userId));
		ordersUnpassed.addAll(getHallLoad(userId));
		ordersUnpassed.addAll(getIncome(userId));
		ordersUnpassed.addAll(getPayment(userId));
		ordersUnpassed.addAll(getRecipient(userId));
		ordersUnpassed.addAll(getSend(userId));
		ordersUnpassed.addAll(getStockIn(userId));
		ordersUnpassed.addAll(getStockOut(userId));
		ordersUnpassed.addAll(getTransit(userId));
		return ordersUnpassed;
	}
	
	private ArrayList<KindGetter> getArrive(String userId){
		OrderOper po = new ArrivePO(null, null, null, null, null, null, null, userId);
		ResultSet result = mysqlSer.checkUnpassed(po);
		if(!isNull(result)){
			ArrayList<KindGetter> list = OrderListFactory.produceArrive(result);
			return list;
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getCenterLoad(String userId){
		OrderOper po = new CenterLoadingPO(null, null, null, null, null, null, null, null, null, 0, userId);
		ResultSet result = mysqlSer.checkUnpassed(po);
		if(!isNull(result)){
			ArrayList<KindGetter> list = OrderListFactory.produceCenterLoad(result);
			return list;
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getExpress(String userId){
		OrderOper po = new ExpressPO(null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 0, 0, 0, 
				null, null, null, null, 0, null, null, null, null, null, null, null, userId);
		ResultSet result = mysqlSer.checkUnpassed(po);
		if(!isNull(result)){
			ArrayList<KindGetter> list = OrderListFactory.produceExpress(result);
			return list;
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getHallLoad(String userId){
		OrderOper po = new HallLoadingPO(null, null, null, null, null, 
				null, null, null, null, null, 0, userId);
		ResultSet result = mysqlSer.checkUnpassed(po);
		if(!isNull(result)){
			ArrayList<KindGetter> list = OrderListFactory.produceHallLoad(result);
			return list;
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getIncome(String userId){
		OrderOper po = new IncomePO(null, null, null, null, null, null, null, null, userId,null);
		ResultSet result = mysqlSer.checkUnpassed(po);
		if(!isNull(result)){
			ArrayList<KindGetter> list = OrderListFactory.produceIncome(result);
			return list;
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getPayment(String userId){
		OrderOper po = new PaymentPO(0, null, null, null, null, null, null, null, null, userId);
		ResultSet result = mysqlSer.checkUnpassed(po);
		if(!isNull(result)){
			ArrayList<KindGetter> list = OrderListFactory.producePayment(result);
			return list;
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getRecipient(String userId){
		OrderOper po = new RecipientPO(null, null, null, null, null, null, null, userId);
		ResultSet result = mysqlSer.checkUnpassed(po);
		if(!isNull(result)){
			ArrayList<KindGetter> list = OrderListFactory.produceRecipient(result);
			return list;
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getSend(String userId){
		OrderOper po = new SendPO(null, null, null, null, null, null, userId);
		ResultSet result = mysqlSer.checkUnpassed(po);
		if(!isNull(result)){
			ArrayList<KindGetter> list = OrderListFactory.produceSend(result);
			return list;
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getStockIn(String userId){
		OrderOper po = new StockInPO(null, null, null, null, null, null, 0, 0, null, null, null, userId);
		ResultSet result = mysqlSer.checkUnpassed(po);
		if(!isNull(result)){
			ArrayList<KindGetter> list = OrderListFactory.produceStockIn(result); 
			return list;
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getStockOut(String userId){
		OrderOper po = new StockOutPO(null, null, null, null, null, null, null, null, null, userId);
		ResultSet result = mysqlSer.checkUnpassed(po);
		if(!isNull(result)){
			ArrayList<KindGetter> list = OrderListFactory.produceStockOut(result);
			return list;
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getTransit(String userId){
		OrderOper po = new TransitPO(null, null, null, null, null, null, null, null, null, null, 0, userId,null);
		ResultSet result = mysqlSer.checkUnpassed(po);
		if(!isNull(result)){
			ArrayList<KindGetter> list = OrderListFactory.produceTransit(result);
			return list;
		} else {
			return new ArrayList<KindGetter>();
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
