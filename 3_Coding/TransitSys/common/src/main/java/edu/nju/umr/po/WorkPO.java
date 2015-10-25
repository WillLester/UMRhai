package edu.nju.umr.po;

import java.io.Serializable;

import edu.nju.umr.po.enums.Jurisdiction;

public class WorkPO implements Serializable{
	private String name;
	private String mobile;
	private String orgId;
	private String id;
	private Jurisdiction juri;
	public WorkPO(String name,String mobile,String orgId,String id,Jurisdiction juri) {
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.mobile = mobile;
		this.orgId = orgId;
		this.id = id;
		this.juri = juri;
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
}
