package edu.nju.umr.po;

import java.io.Serializable;

import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Wage;

public class WorkPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2266208732773899274L;
	private String name;
	private String mobile;
	private String org;
	private int id;
	private Jurisdiction juri;
	private Wage kind;
	private int money;
	private int commission;
	public WorkPO(String name,String mobile,String org,int id,Jurisdiction juri) {
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.mobile = mobile;
		this.org = org;
		this.id = id;
		this.juri = juri;
	}
	
	public WorkPO(String name, String mobile, String org, int id,
			Jurisdiction juri, Wage kind, int money, int commission) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.org = org;
		this.id = id;
		this.juri = juri;
		this.kind = kind;
		this.money = money;
		this.commission = commission;
	}

	public String getName() {
		return name;
	}
	public String getMobile() {
		return mobile;
	}
	public String getOrg() {
		return org;
	}
	public int getId() {
		return id;
	}
	public Jurisdiction getJuri() {
		return juri;
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

	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into work values"+"("+id+",'"+org+"',"+kind.ordinal()+","+money+","+commission+")";break;
		case DELETE:command="delete from work where id='"+id+"'";break;
		case FIND:break;
		case UPDATE:command="update work set org='"+org+"' kind="+kind.ordinal()+" money="+money+" commission="+commission+" where id="+id;break;
		}
		return command;
	}
}
