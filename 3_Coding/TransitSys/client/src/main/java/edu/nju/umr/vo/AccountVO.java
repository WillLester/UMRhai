package edu.nju.umr.vo;

public class AccountVO {
	private String id;
	private String name;
	private int balance;
	public AccountVO(String name,int balance) {
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
