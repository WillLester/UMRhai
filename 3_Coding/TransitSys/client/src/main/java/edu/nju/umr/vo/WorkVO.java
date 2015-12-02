package edu.nju.umr.vo;

import edu.nju.umr.po.enums.Jurisdiction;

public class WorkVO {
	private String name;
	private String mobile;
	private String org;
	private Jurisdiction juri;

	public WorkVO(String name, String mobile, String org,
			Jurisdiction juri) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.org = org;
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
	public Jurisdiction getJuri() {
		return juri;
	}

}
