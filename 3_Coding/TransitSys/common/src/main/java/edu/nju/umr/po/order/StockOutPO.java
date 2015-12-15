package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.po.order.function.GetToday;
import edu.nju.umr.po.order.function.KindGetter;
import edu.nju.umr.po.order.function.OrderOper;

public class StockOutPO extends PO implements Serializable,KindGetter,OrderOper,GetToday{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2102785279404595176L;
	private String id;
	private String expressId;
	private Calendar date;
	private Transit kind;
	private String arrivePlace;
	private String transitId;
	private Calendar opTime;
	private String opName;
	private String stockId;
	private String userId;
	
	public StockOutPO(String id, String expressId, Calendar date, Transit kind,String arrivePlace,
			String transitId, Calendar opTime, String opName, String stockId,String userId) {
		super();
		this.id = id;
		this.expressId = expressId;
		this.date = date;
		this.kind = kind;
		this.arrivePlace = arrivePlace;
		this.transitId = transitId;
		this.opTime = opTime;
		this.opName = opName;
		this.stockId = stockId;
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public String getExpressId() {
		return expressId;
	}
	public Calendar getDate() {
		return date;
	}
	public Transit getKind() {
		return kind;
	}
	public String getArrivePlace() {
		return arrivePlace;
	}
	public String getTransitId() {
		return transitId;
	}
	public Calendar getOpTime() {
		return opTime;
	}
	public String getOpName() {
		return opName;
	}
	public String getStockId() {
		return stockId;
	}
	public String getUserId() {
		return userId;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into stockoutorderwaiting values"+"('"+id+"','"+expressId+"',"+
		kind.ordinal()+",'"+transitId+"','"+DateFormat.DATE.format(date.getTime())+"','"+
				DateFormat.TIME.format(opTime.getTime())+"','"+opName+"','"+stockId+"','"+arrivePlace+"','"+userId+"')";
		System.out.println(command);
		break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	@Override
	public Order getOrderKind() {
		// TODO 自动生成的方法存根
		return Order.STOCKOUT;
	}
	@Override
	public String getApprove(boolean isPassed) {
		// TODO 自动生成的方法存根
		if(isPassed){
			return "insert into stockoutorderpassed select * from stockoutorderwaiting where id='"+id+"'";
		} else {
			return "insert into stockoutorderunpassed select * from stockoutorderwaiting where id='"+id+"'";
		}
	}
	@Override
	public String getDeleteWaiting() {
		// TODO 自动生成的方法存根
		return "delete from stockoutorderwaiting where id='"+id+"'";
	}
	@Override
	public String getDeleteUnpassed() {
		// TODO 自动生成的方法存根
		return "delete from stockoutorderunpassed where id='"+id+"'";
	}
	@Override
	public String getDetail() {
		// TODO 自动生成的方法存根
		return "select * from stockoutorderwaiting where id='"+id+"'";
	}
	@Override
	public String getUnpassed() {
		// TODO 自动生成的方法存根
		return "select * from stockoutorderunpassed where userId ='"+userId+"'";
	}
	@Override
	public String getToday() {
		// TODO 自动生成的方法存根
		return "select * from stockoutorderwaiting where id like '%"+id+"%' union "
				+ "select * from stockoutorderpassed where id like '%"+id+"%' union "
				+ "select * from stockoutorderunpassed where id like '%"+id+"%'";
	}
}
