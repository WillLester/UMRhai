package edu.nju.umr.po;

import java.io.Serializable;

import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Wage;

public class WorkPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2266208732773899274L;
	private String name;
	private String mobile;
	private String orgId;
	private String id;
	private Jurisdiction juri;
	private Wage kind;
	private int money;
	private int commission;
	public WorkPO(String name,String mobile,String orgId,String id,Jurisdiction juri) {
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.mobile = mobile;
		this.orgId = orgId;
		this.id = id;
		this.juri = juri;
	}
	
	public WorkPO(String name, String mobile, String orgId, String id,
			Jurisdiction juri, Wage kind, int money, int commission) {
		super();
		this.name = name;
		this.mobile = mobile;
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
	public String getOrgId() {
		return orgId;
	}
	public String getId() {
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
}
