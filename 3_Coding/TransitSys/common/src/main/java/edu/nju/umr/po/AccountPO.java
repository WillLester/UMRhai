package edu.nju.umr.po;

import java.io.Serializable;

import edu.nju.umr.po.enums.MysqlOperation;

public class AccountPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6350938083073701474L;
	private int id;
	private String name;
	private double balance;
	
	public AccountPO(int id, String name, double balance) {
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
	public double getBalance() {
		return balance;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op)
		{
		case INSERT:command = "insert into account values"+"("+id+","+"'"+name+"',"+balance+")";break;
		case DELETE:command = "delete from account where id="+id;break;
		case FIND:command = "select * from account where name like '%"+name+"%'";break;
		case UPDATE:command = "update account set name='"+name+"',balance="+balance+" where id="+id;break;
		}
		return command;
	}
}
