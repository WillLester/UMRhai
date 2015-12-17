package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.GoodState;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.order.function.GetToday;
import edu.nju.umr.po.order.function.KindGetter;
import edu.nju.umr.po.order.function.OrderOper;

public class RecipientPO extends PO implements Serializable,KindGetter,OrderOper,GetToday{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1377652016004151729L;
	private Calendar date;
	private String id;
	private String transitId;
	private String startPlace;
	private GoodState state;
	private Calendar opTime;
	private String opName;
	private String userId;
	
	public RecipientPO(Calendar date, String id, String transitId,
			String startPlace, GoodState state, Calendar opTime, String opName,String userId) {
		super();
		this.date = date;
		this.id = id;
		this.transitId = transitId;
		this.startPlace = startPlace;
		this.state = state;
		this.opTime = opTime;
		this.opName = opName;
		this.userId = userId;
	}
	public Calendar getDate() {
		return date;
	}
	public String getId() {
		return id;
	}
	public String getTransitId() {
		return transitId;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public GoodState getState() {
		return state;
	}
	public Calendar getOpTime() {
		return opTime;
	}
	public String getOpName() {
		return opName;
	}
	public String getUserId() {
		return userId;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into recipientorderwaiting values"+"("+id+",'"+transitId+"','"+startPlace+"',"+state.ordinal()+",'"+
		DateFormat.DATE.format(date.getTime())+"','"+DateFormat.TIME.format(opTime.getTime())+"','"+opName+"','"+userId+"')";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	@Override
	public Order getOrderKind() {
		// TODO 自动生成的方法存根
		return Order.RECIPIENT;
	}
	@Override
	public String getApprove(boolean isPassed) {
		// TODO 自动生成的方法存根
		if(isPassed){
			return "insert into recipientorderpassed select * from recipientorderwaiting where id='"+id+"'";
		} else {
			return "insert into recipientorderunpassed select * from recipientorderwaiting where id='"+id+"'";
		}
	}
	@Override
	public String getDeleteWaiting() {
		// TODO 自动生成的方法存根
		return "delete from recipientorderwaiting where id='"+id+"'";
	}
	@Override
	public String getDeleteUnpassed() {
		// TODO 自动生成的方法存根
		return "delete from recipientorderunpassed where id='"+id+"'";
	}
	@Override
	public String getDetail() {
		// TODO 自动生成的方法存根
		return "select * from recipientorderwaiting where id='"+id+"'";
	}
	@Override
	public String getUnpassed() {
		// TODO 自动生成的方法存根
		return "select * from recipientorderunpassed where userId='"+userId+"'";
	}
	@Override
	public String getToday() {
		// TODO 自动生成的方法存根
		return "select * from recipientorderwaiting where id like '%"+id+"%' union "
				+ "select * from recipientorderpassed where id like '%"+id+"%' union "
				+ "select * from recipientorderunpassed where id like '%"+id+"%'";
	}
}
