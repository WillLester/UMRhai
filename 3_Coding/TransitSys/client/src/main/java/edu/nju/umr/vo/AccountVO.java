package edu.nju.umr.vo;


public class AccountVO {
	private String name;
	private double balance;
	public AccountVO(String name,double balance) {
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public double getBalance() {
		return balance;
	}
	
}
