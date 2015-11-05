package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import edu.nju.umr.po.enums.Pay;

public class PaymentPO implements Serializable{
	private String id;
	private Date date;
	private String payer;
	private String account;
	private Pay kind;
	private double amount;
	private String remarks;
	private Calendar opTime;
	
	public PaymentPO(String id, Date date, String payer, String account,
			Pay kind, double amount, String remarks, Calendar opTime) {
		super();
		this.id = id;
		this.date = date;
		this.payer = payer;
		this.account = account;
		this.kind = kind;
		this.amount = amount;
		this.remarks = remarks;
		this.opTime = opTime;
	}
	public String getId() {
		return id;
	}
	public Date getDate() {
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
	
}
