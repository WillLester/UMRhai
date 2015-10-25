package edu.nju.umr.vo;


public class AccountVO {
	private String id;
	private String name;
	private int balance;
	public AccountVO(String id,String name,int balance) {
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
	
}
