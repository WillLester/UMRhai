package edu.nju.umr.po.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.order.function.GetToday;
import edu.nju.umr.po.order.function.KindGetter;
import edu.nju.umr.po.order.function.OrderOper;

public class IncomePO extends PO implements Serializable,KindGetter,OrderOper,GetToday{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1315709059088122485L;
	private Calendar date;
	private String courier;
	private BigDecimal cost;
	private ArrayList<String> express;
	private String id;
	private Calendar opTime;
	private String opName;
	private String orgId;
	private String userId;
	private String account;
	
	
	public IncomePO(Calendar date, String courier, BigDecimal cost,
			ArrayList<String> express, String id, Calendar opTime, String opName,
			String orgId, String userId, String account) {
		super();
		this.date = date;
		this.courier = courier;
		this.cost = cost;
		this.express = express;
		this.id = id;
		this.opTime = opTime;
		this.opName = opName;
		this.orgId = orgId;
		this.userId = userId;
		this.account = account;
	}
	public String getUserId() {
		return userId;
	}
	public Calendar getDate() {
		return date;
	}
	public String getCourier() {
		return courier;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public ArrayList<String> getExpress() {
		return express;
	}
	public String getId() {
		return id;
	}
	public Calendar getOpTime() {
		return opTime;
	}
	public String getOpName() {
		return opName;
	}
	
	public String getOrgId() {
		return orgId;
	}
	public String getAccount() {
		return account;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:
			String text = "";
			for(String exp:express){
				text = text + exp + " ";
			}
			command="insert into incomeorderwaiting values"+"('"+id+"','"+courier+"',"+cost+",'"+DateFormat.DATE.format(date.getTime())+"','"+
			DateFormat.TIME.format(opTime.getTime())+"','"+text+"','"+opName+"','"+orgId+"','"+userId+"','"+account+"')";break;
		case DELETE:break;
		case FIND:
			command = "select * from incomeorderpassed where orgId='"+orgId+"'";
			break;
		case UPDATE:break;
		}
		return command;
	}
	@Override
	public Order getOrderKind() {
		// TODO 自动生成的方法存根
		return Order.INCOME;
	}
	@Override
	public String getApprove(boolean isPassed) {
		// TODO 自动生成的方法存根
		if(isPassed){
			return "insert into incomeorderpassed select * from incomeorderwaiting where id='"+id+"'";
		} else {
			return "insert into incomeorderunpassed select * from incomeorderwaiting where id='"+id+"'";
		}
	}
	@Override
	public String getDeleteWaiting() {
		// TODO 自动生成的方法存根
		return "delete from incomeorderwaiting where id='"+id+"'";
	}
	@Override
	public String getDeleteUnpassed() {
		// TODO 自动生成的方法存根
		return "delete from incomeorderunpassed where id ='"+id+"'";
	}
	@Override
	public String getDetail() {
		// TODO 自动生成的方法存根
		return "select * from incomeorderwaiting where id='"+id+"'";
	}
	@Override
	public String getUnpassed() {
		// TODO 自动生成的方法存根
		return "select * from incomeorderunpassed where userId ='"+userId+"'";
	}
	@Override
	public String getToday() {
		// TODO 自动生成的方法存根
		return "select * from incomeorderwaiting where id like '%"+id+"%' union "
				+ "select * from incomeorderpassed where id like '%"+id+"%' union "
						+ "select * from incomeorderunpassed where id like '%"+id+"%'";
	}
}
