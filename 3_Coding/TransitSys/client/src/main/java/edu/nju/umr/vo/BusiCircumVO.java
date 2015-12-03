package edu.nju.umr.vo;

import java.util.Calendar;

import edu.nju.umr.po.enums.Pay;

public class BusiCircumVO {
	private int type;//0代表收款单，1代表付款单
	private Calendar date;
	private double amount;
	private Pay kind;
	
	public BusiCircumVO(int kind,Calendar date,double amount,Pay remark){
		this.type=kind;
		this.date=date;
		this.amount=amount;
		this.kind=remark;
	}
	
	public int getKind(){
		return type;
	}
	
	public Calendar getDate(){
		return date;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public Pay getRemark(){
		return kind;
	}
}
