package edu.nju.umr.data.orderApproveData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.OrderPOFactory;
import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;
import edu.nju.umr.po.PO;
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
/*
 * 单据审批数据
 */
public class OrderApproveData extends UnicastRemoteObject implements OrderApproveDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3649658232155573648L;
	private MysqlService mysqlSer;

	public OrderApproveData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
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
		PO po;
		switch(kind){
		case ARRIVE:
			po = new ArrivePO(null, null, id, null, null, null, null,null);
			return OrderPOFactory.getArrive(mysqlSer.checkInfo(po));
		case CENTERLOADING:
			po = new CenterLoadingPO(null, id, null, null, null, null, null, null, null, 0,null);
			return OrderPOFactory.getCenterLoad(mysqlSer.checkInfo(po));
		case EXPRESS:
			po = new ExpressPO(null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 0, 0, 0, id,
					null, null, null, 0, null, null, null, null, null, null, null,null);
			return OrderPOFactory.getExpress(mysqlSer.checkInfo(po));
		case HALLLOADING:
			po = new HallLoadingPO(id, null, null, null, null, null, null, null, null, null, null, 0,null);
			return OrderPOFactory.getHallLoad(mysqlSer.checkInfo(po));
		case INCOME:
			po = new IncomePO(null, null, 0, null, Integer.parseInt(id), null, null, null,null);
			return OrderPOFactory.getIncome(mysqlSer.checkInfo(po));
		case PAYMENT:
			po = new PaymentPO(Integer.parseInt(id), null, null, null, null, 0, null, null, null,null);
			return OrderPOFactory.getPayment(mysqlSer.checkInfo(po));
		case RECIPIENT:
			po = new RecipientPO(null, id, null, null, null, null, null,null);
			return OrderPOFactory.getRecipient(mysqlSer.checkInfo(po));
		case SEND:
			po = new SendPO(null, null, id, null, null, null,null);
			return OrderPOFactory.getSend(mysqlSer.checkInfo(po));
		case STOCKIN:
			po = new StockInPO(Integer.parseInt(id), null, null, null, null, null, 0, 0, null, null, null,null);
			return OrderPOFactory.getStockIn(mysqlSer.checkInfo(po));
		case STOCKOUT:
			po = new StockOutPO(Integer.parseInt(id), null, null, null, null, null, null, null, null,null);
			return OrderPOFactory.getStockOut(mysqlSer.checkInfo(po));
		case TRANSIT:
			po = new TransitPO(id, null, null, null, null, null, null, null, null, null, 0,null);
			return OrderPOFactory.getTransit(mysqlSer.checkInfo(po));
		default:
			return null;
		}
	}

}
