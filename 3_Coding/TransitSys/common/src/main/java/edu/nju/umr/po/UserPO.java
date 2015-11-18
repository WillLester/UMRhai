package edu.nju.umr.po;

import java.io.Serializable;

import edu.nju.umr.po.enums.Jurisdiction;

public class UserPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2720840768406998251L;
	private String id;
	private String password;
	private Jurisdiction juri;
	private String name;
	private String mobile;
	private String org;
	private int key;
	public UserPO(String id,String password,Jurisdiction juri,String name,String mobile,String org,int key) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.password = password;
		this.juri = juri;
		this.name = name;
		this.mobile = mobile;
		this.org = org;
		this.key=key;
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
	public int getKey(){
		return key;
	}
}
