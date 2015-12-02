package edu.nju.umr.vo;

import edu.nju.umr.po.enums.Jurisdiction;

public class WorkVO {
	private String name;
	private String mobile;
	private String org;
	private String orgId;
	private Jurisdiction juri;

	public WorkVO(String name, String mobile, String org, String orgId,
			Jurisdiction juri) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.org = org;
		this.orgId = orgId;
		this.juri = juri;
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
	public Jurisdiction getJuri() {
		return juri;
	}

}
