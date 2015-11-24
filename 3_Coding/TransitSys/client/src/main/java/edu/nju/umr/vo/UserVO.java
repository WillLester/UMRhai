package edu.nju.umr.vo;

import edu.nju.umr.po.enums.Jurisdiction;

public class UserVO {
	private String id;
	private String password;
	private Jurisdiction juri;
	private String name;
	private String mobile;
	private String org;
	private String orgId;
//	private int number;
	public UserVO(String id,String password,Jurisdiction juri,String name,String mobile,String org,String orgId) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.password = password;
		this.juri = juri;
		this.name = name;
		this.mobile = mobile;
		this.org = org;
		this.orgId=orgId;
//		this.number=number;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public Jurisdiction getJuri() {
		return juri;
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
	public String getOrgId(){
		return orgId;
	}
//	public int getNumber(){
//		return number;
//	}
}
