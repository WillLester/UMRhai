package edu.nju.umr.vo;

import edu.nju.umr.po.enums.Jurisdiction;

public class UserVO {
	private String userName;
	private String password;
	private Jurisdiction juri;
	private String name;
	private String mobile;
	private String org;
//	private int key;
	public UserVO(String userName,String password,Jurisdiction juri,String name,String mobile,String org) {
		// TODO 自动生成的构造函数存根
		this.userName = userName;
		this.password = password;
		this.juri = juri;
		this.name = name;
		this.mobile = mobile;
		this.org = org;
//		this.key=key;
	}
	public String getUserName() {
		return userName;
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
//	public int getNumber(){
//		return key;
//	}
}
