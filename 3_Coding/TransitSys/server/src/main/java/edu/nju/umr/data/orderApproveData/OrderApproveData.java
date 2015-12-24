package edu.nju.umr.data.orderApproveData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.data.utilityData.OrderPOFactory;
import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.po.order.TransitPO;
import edu.nju.umr.po.order.function.OrderOper;
/*
 * 单据审批数据
 */
public class OrderApproveData extends UnicastRemoteObject implements OrderApproveDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3649658232155573648L;
	private MysqlService mysqlSer;
	private static OrderApproveData data = null;
	private OrderApproveData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static OrderApproveData getOrderApprove() throws RemoteException{
		if(data == null){
			data = new OrderApproveData();
		}
		return data;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<OrderPO> getExamine() throws RemoteException {
		// TODO 自动生成的方法存根
		return (ArrayList<OrderPO>) mysqlSer.checkAll(POKind.ORDER);
	}

	public Result update(boolean isPassed,ArrayList<String> id,Order kind) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.updateOrder(isPassed, id, kind);
	}

	public PO getOrder(String id,Order kind) throws RemoteException {
		// TODO 自动生成的方法存根
		OrderOper po;
		switch(kind){
		case ARRIVE:
			po = new ArrivePO(null, null, id, null, null, null, null,null);
			return OrderPOFactory.getArrive(mysqlSer.checkOrder(po));
		case CENTERLOADING:
			po = new CenterLoadingPO(null, id, null, null, null, null, null, null, null, 0,null,false,null,null);
			return OrderPOFactory.getCenterLoad(mysqlSer.checkOrder(po));
		case EXPRESS:
			po = new ExpressPO(null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 0, 0, 0, id,
					null, null, null, 0, null, null, null, null, null, null, null,null,null);
			return OrderPOFactory.getExpress(mysqlSer.checkOrder(po));
		case HALLLOADING:
			po = new HallLoadingPO(null, id, null, null, null, null, null, null, null, null, 0,null,false);
			return OrderPOFactory.getHallLoad(mysqlSer.checkOrder(po));
		case INCOME:
			po = new IncomePO(null, null, null, null, id, null, null, null,null,null);
			return OrderPOFactory.getIncome(mysqlSer.checkOrder(po));
		case PAYMENT:
			po = new PaymentPO(id, null, null, null, null, null, null, null, null,null);
			return OrderPOFactory.getPayment(mysqlSer.checkOrder(po));
		case RECIPIENT:
			po = new RecipientPO(null, id, null, null, null, null, null,null);
			return OrderPOFactory.getRecipient(mysqlSer.checkOrder(po));
		case SEND:
			po = new SendPO(null, null, id, null, null, null,null);
			return OrderPOFactory.getSend(mysqlSer.checkOrder(po));
		case STOCKIN:
			po = new StockInPO(id, null, null, null, null, null, 0, 0, null, null, null,null);
			return OrderPOFactory.getStockIn(mysqlSer.checkOrder(po));
		case STOCKOUT:
			po = new StockOutPO(id, null, null, null, null, null, null, null, null,null);
			return OrderPOFactory.getStockOut(mysqlSer.checkOrder(po));
		case TRANSIT:
			po = new TransitPO(id, null, null, null, null, null, null, null, null, null, 0,null,null,false,null);
			return OrderPOFactory.getTransit(mysqlSer.checkOrder(po));
		default:
			return null;
		}
	}

	@Override
	public UserPO getUser(String userId) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new UserPO(userId, null, null, null, null, null, 0, null));
		ArrayList<UserPO> users = ArrayListFactory.produceUserList(result);	
		return users.get(0);
	}

}
