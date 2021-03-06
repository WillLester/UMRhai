package edu.nju.umr.po.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.order.function.GetToday;
import edu.nju.umr.po.order.function.KindGetter;
import edu.nju.umr.po.order.function.OrderOper;

public class PaymentPO extends PO implements Serializable,KindGetter,OrderOper,GetToday{
	/**
	 * 
	 */
	private static final long serialVersionUID = -763899204690976592L;
	private String id;
	private Calendar date;
	private String payer;
	private String account;
	private Pay kind;
	private BigDecimal amount;
	private String remarks;
	private Calendar opTime;
	private String opName;
	private String userId;
	
	public PaymentPO(String id, Calendar date, String payer, String account,
			Pay kind, BigDecimal amount, String remarks, Calendar opTime,
			String opName,String userId) {
		super();
		this.id = id;
		this.date = date;
		this.payer = payer;
		this.account = account;
		this.kind = kind;
		this.amount = amount;
		this.remarks = remarks;
		this.opTime = opTime;
		this.opName = opName;
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public Calendar getDate() {
		return date;
	}
	public String getPayer() {
		return payer;
	}
	public String getAccount() {
		return account;
	}
	public Pay getKind() {
		return kind;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public String getRemarks() {
		return remarks;
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
		case INSERT:command="insert into paymentorderwaiting values"+"('"+id+"','"+payer+"','"+account+"',"+kind.ordinal()+","+amount+",'"+remarks+"','"+
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
		return Order.PAYMENT;
	}
	@Override
	public String getApprove(boolean isPassed) {
		// TODO 自动生成的方法存根
		if(isPassed){
			return "insert into paymentorderpassed select * from paymentorderwaiting where id='"+id+"'";
		} else {
			return "insert into paymentorderunpassed select * from paymentorderwaiting where id='"+id+"'";
		}
	}
	@Override
	public String getDeleteWaiting() {
		// TODO 自动生成的方法存根
		return "delete from paymentorderwaiting where id='"+id+"'";
	}
	@Override
	public String getDeleteUnpassed() {
		// TODO 自动生成的方法存根
		return "delete from paymentorderunpassed where id='"+id+"'";
	}
	@Override
	public String getDetail() {
		// TODO 自动生成的方法存根
		return "select * from paymentorderwaiting where id='"+id+"'";
	}
	@Override
	public String getUnpassed() {
		// TODO 自动生成的方法存根
		return "select * from paymentorderunpassed where userId='"+userId+"'";
	}
	@Override
	public String getToday() {
		// TODO 自动生成的方法存根
		return "select * from paymentorderwaiting where id like '%"+id+"%' union "
				+ "select * from paymentorderpassed where id like '%"+id+"%' union "
				+ "select * from paymentorderunpassed where id like '%"+id+"%'";
	}
	
}
