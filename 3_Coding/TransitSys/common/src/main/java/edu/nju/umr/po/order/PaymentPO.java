package edu.nju.umr.po.order;

import java.util.Date;

import edu.nju.umr.po.enums.Pay;

public class PaymentPO {
	private String id;
	private Date date;
	private String payer;
	private String account;
	private Pay kind;
	private double amount;
	private String remarks;
	public PaymentPO(String id,Date date,String payer,String account,Pay kind,double amount,String remarks) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.date = date;
		this.payer = payer;
		this.account = account;
		this.kind = kind;
		this.amount = amount;
		this.remarks = remarks;
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
}
