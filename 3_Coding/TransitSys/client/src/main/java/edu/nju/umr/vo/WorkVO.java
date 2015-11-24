package edu.nju.umr.vo;

import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Wage;

public class WorkVO {
	private String name;
	private String mobile;
	private String org;
	private String orgId;
//	private int id;
	private Jurisdiction juri;
	private Wage kind;
	private int money;
	private int commission;

	public WorkVO(String name, String mobile, String org, String orgId,
			Jurisdiction juri, Wage kind, int money, int commission) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.org = org;
		this.orgId = orgId;
//		this.id = id;
		this.juri = juri;
		this.kind = kind;
		this.money = money;
		this.commission = commission;
	}
	public WorkVO(String name, String mobile, String org, String orgId,
			Jurisdiction juri, Wage kind, int money) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.org = org;
		this.orgId = orgId;
//		this.id = id;
		this.juri = juri;
		this.kind = kind;
		this.money = money;
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
	public String getOrgId() {
		return orgId;
	}
//	public String getId() {
//		return id;
//	}
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
