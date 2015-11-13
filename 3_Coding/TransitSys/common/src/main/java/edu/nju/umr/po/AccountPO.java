package edu.nju.umr.po;

import java.io.Serializable;

public class AccountPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6350938083073701474L;
	private String id;
	private String name;
	private int balance;
	
	public AccountPO(String id, String name, int balance) {
		super();
		this.id = id;
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
