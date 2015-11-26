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
	private String orgId;
	private int id;
	private Jurisdiction juri;
	private Wage kind;
	private int money;
	private int commission;

	public WorkPO(String name, String mobile, String org, String orgId, int id,
			Jurisdiction juri, Wage kind, int money, int commission) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.org = org;
		this.orgId = orgId;
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

	public String getOrgId() {
		return orgId;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into user values"+"(null,null,null,null,0,0,'"+orgId+"','"+org+"',"+kind.ordinal()+","+money+","+commission+")";break;
		case DELETE:command="delete from user where id='"+id+"'";break;
		case FIND:command = "select * from user where name like %"+name+"% or juri ="+juri.ordinal()+" or org like %"+org+"%";break;
		case UPDATE:command="update user set orgId='"+org+"',kind="+kind.ordinal()+",money="+money+",commission="+commission+" where id="+id;break;
		}
		return command;
	}
}
