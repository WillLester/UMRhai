package edu.nju.umr.vo;

import java.math.BigDecimal;


public class AccountVO {
	private String name;
	private BigDecimal balance;
	public AccountVO(String name,BigDecimal balance) {
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	
}
