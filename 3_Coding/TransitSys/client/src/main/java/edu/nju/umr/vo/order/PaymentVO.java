package edu.nju.umr.vo.order;

import java.util.Calendar;

import edu.nju.umr.po.enums.Pay;

public class PaymentVO {
//	private String id;
	private Calendar date;
	private String payer;
	private String account;
	private Pay kind;
	private double amount;
	private String remarks;
	private String opName;
	private String userId;
	public PaymentVO(Calendar date,String payer,String account,Pay kind,double amount,String remarks,String opName,String userId) {
		// TODO 自动生成的构造函数存根
//		this.id = id;
		this.date = date;
		this.payer = payer;
		this.account = account;
		this.kind = kind;
		this.amount = amount;
		this.remarks = remarks;
		this.opName=opName;
		this.userId = userId;
	}
//	public String getId() {
//		return id;
//	}
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
	public String getOpName() {
		return opName;
	}
	public String getUserId() {
		return userId;
	}
}
