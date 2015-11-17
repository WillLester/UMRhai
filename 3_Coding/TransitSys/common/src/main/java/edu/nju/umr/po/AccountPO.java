package edu.nju.umr.po;

import java.io.Serializable;

public class AccountPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6350938083073701474L;
	private int id;
	private String name;
	private int balance;
	
	public AccountPO(int id, String name, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
}
