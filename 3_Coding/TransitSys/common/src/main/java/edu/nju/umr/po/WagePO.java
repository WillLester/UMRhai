package edu.nju.umr.po;

import edu.nju.umr.po.enums.Wage;

public class WagePO {
	private String workerId;
	private Wage kind;
	private int money;
	private int commission;
	public WagePO(String workerId,Wage kind,int money) {
		// TODO 自动生成的构造函数存根
	}
	public WagePO(String workerId,Wage kind,int money,int commission) {
		// TODO 自动生成的构造函数存根
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
