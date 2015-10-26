package edu.nju.umr.vo;

import edu.nju.umr.po.enums.Wage;

public class WageVO {
	private String workerId;
	private Wage kind;
	private int money;
	private int commission;
	public WageVO(String workerId,Wage kind,int money) {
		// TODO 自动生成的构造函数存根
		this.workerId=workerId;
		this.kind=kind;
		this.money=money;
	}
	public WageVO(String workerId,Wage kind,int money,int commission) {
		// TODO 自动生成的构造函数存根
		this.workerId=workerId;
		this.kind=kind;
		this.money=money;
		this.commission=commission;
	}
	public String getWorkerId() {
		return workerId;
	}
	public Wage getKind() {
		return kind;
	}
	public int getMoney() {
		return money;
	}
	public int getCommission() {
		return commission;
	}
}
