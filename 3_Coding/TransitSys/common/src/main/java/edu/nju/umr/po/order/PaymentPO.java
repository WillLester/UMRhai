package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Pay;

public class PaymentPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -763899204690976592L;
	private int id;
	private Calendar date;
	private String payer;
	private String account;
	private Pay kind;
	private double amount;
	private String remarks;
	private Calendar opTime;
	private String opName;
	
	public PaymentPO(int id, Calendar date, String payer, String account,
			Pay kind, double amount, String remarks, Calendar opTime,
			String opName) {
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
	}
	public int getId() {
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
	public double getAmount() {
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
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into paymentorderwaiting values"+"("+id+",'"+payer+"','"+account+"',"+kind.ordinal()+","+amount+",'"+remarks+"','"+DateFormat.DATE.format(date.getTime())+"','"+DateFormat.TIME.format(opTime.getTime())+"','"+opName+"')";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	
}
