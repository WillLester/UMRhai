package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;

public class SendPO extends PO implements Serializable,KindGetter,OrderOper{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8813726054468447799L;
	private Calendar date;
	private String expressId;
	private String id;
	private String courier;
	private Calendar opTime;
	private String opName;
	
	public SendPO(Calendar date, String expressId, String id, String courier,
			Calendar opTime, String opName) {
		super();
		this.date = date;
		this.expressId = expressId;
		this.id = id;
		this.courier = courier;
		this.opTime = opTime;
		this.opName = opName;
	}
	public Calendar getDate() {
		return date;
	}
	public String getExpressId() {
		return expressId;
	}
	public String getId() {
		return id;
	}
	public String getCourier() {
		return courier;
	}
	public Calendar getOpTime() {
		return opTime;
	}
	public String getOpName() {
		return opName;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into sendorderwaiting values"+"("+id+",'"+expressId+"','"+courier+"','"+DateFormat.DATE.format(date.getTime())+"','"+DateFormat.TIME.format(opTime.getTime())+"','"+opName+"')";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	@Override
	public Order getOrderKind() {
		// TODO 自动生成的方法存根
		return Order.SEND;
	}
	@Override
	public String getApprove(boolean isPassed) {
		// TODO 自动生成的方法存根
		if(isPassed){
			
		}
		return null;
	}
	@Override
	public String getDeleteWaiting() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public String getDeleteUnpassed() {
		// TODO 自动生成的方法存根
		return null;
	}
}
