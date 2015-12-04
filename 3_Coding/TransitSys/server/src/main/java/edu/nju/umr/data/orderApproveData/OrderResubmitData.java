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
import edu.nju.umr.po.order.KindGetter;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.po.order.TransitPO;
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
		ResultSet result = mysqlSer.checkUnpassed(new ArrivePO(null, null, null, null, null, null, null, userId));
		if(!isNull(result)){
			return OrderListFactory.produceArrive(result);
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getCenterLoad(String userId){
		ResultSet result = mysqlSer.checkUnpassed(new CenterLoadingPO(null, null, null, null, null, null, null, null, null, 0, userId));
		if(!isNull(result)){
			return OrderListFactory.produceCenterLoad(result);
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getExpress(String userId){
		ResultSet result = mysqlSer.checkUnpassed(new ExpressPO(null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 0, 0, 0, 
				null, null, null, null, 0, null, null, null, null, null, null, null, userId));
		if(!isNull(result)){
			return OrderListFactory.produceExpress(result);
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getHallLoad(String userId){
		ResultSet result = mysqlSer.checkUnpassed(new HallLoadingPO(null, null, null, null, null, null, 
				null, null, null, null, null, 0, userId));
		if(!isNull(result)){
			return OrderListFactory.produceHallLoad(result);
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getIncome(String userId){
		ResultSet result = mysqlSer.checkUnpassed(new IncomePO(null, null, 0, null, 0, null, null, null, userId));
		if(!isNull(result)){
			return OrderListFactory.produceIncome(result);
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getPayment(String userId){
		ResultSet result = mysqlSer.checkUnpassed(new PaymentPO(0, null, null, null, null, 0, null, null, null, userId));
		if(!isNull(result)){
			return OrderListFactory.producePayment(result);
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getRecipient(String userId){
		ResultSet result = mysqlSer.checkUnpassed(new RecipientPO(null, null, null, null, null, null, null, userId));
		if(!isNull(result)){
			return OrderListFactory.produceRecipient(result);
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getSend(String userId){
		ResultSet result = mysqlSer.checkUnpassed(new SendPO(null, null, null, null, null, null, userId));
		if(!isNull(result)){
			return OrderListFactory.produceSend(result);
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getStockIn(String userId){
		ResultSet result = mysqlSer.checkUnpassed(new StockInPO(0, null, null, null, null, null, 0, 0, null, null, null, userId));
		if(!isNull(result)){
			return OrderListFactory.produceStockIn(result);
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getStockOut(String userId){
		ResultSet result = mysqlSer.checkUnpassed(new StockOutPO(0, null, null, null, null, null, null, null, null, userId));
		if(!isNull(result)){
			return OrderListFactory.produceStockOut(result);
		} else {
			return new ArrayList<KindGetter>();
		}
	}
	
	private ArrayList<KindGetter> getTransit(String userId){
		ResultSet result = mysqlSer.checkUnpassed(new TransitPO(null, null, null, null, null, null, null, null, null, null, 0, userId));
		if(!isNull(result)){
			return OrderListFactory.produceTransit(result);
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
