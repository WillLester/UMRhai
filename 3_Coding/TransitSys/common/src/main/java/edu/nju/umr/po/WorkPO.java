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
		case INSERT:
			command="insert into user values"+"(null,null,'"+name+"','"+mobile+"',"+juri.ordinal()+",0,'"+orgId+"','"+org+"',"+kind.ordinal()+","+money+","+commission+")";break;
		case DELETE:command="delete from user where keyid="+id;break;
		case FIND:
			if(juri == null){
				command = "select * from user where name like '%"+name+"%' or org like '%"+org+"%'";
			} else {
				if(orgId == null){
					command = "select * from user where juri="+juri.ordinal();
				} else {
					command = "select * from user where juri = "+ juri.ordinal() +" and orgId = '"+orgId+"'";
				}
			}
			break;
		case UPDATE:command="update user set name = '"+name+"',mobile = '"+mobile+"',juri = "+juri.ordinal()+", orgId='"+orgId+"',org = '"+org+"',kind="+kind.ordinal()+",money="+money+",commission="+commission+" where keyid="+id;break;
		}
		return command;
	}
}
