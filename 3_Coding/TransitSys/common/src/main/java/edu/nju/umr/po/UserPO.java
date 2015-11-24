package edu.nju.umr.po;

import java.io.Serializable;

import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.MysqlOperation;

public class UserPO extends PO implements Serializable{
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
	private String orgId;
	
	public UserPO(String id, String password, Jurisdiction juri, String name,
			String mobile, String org, int key, String orgId) {
		super();
		this.id = id;
		this.password = password;
		this.juri = juri;
		this.name = name;
		this.mobile = mobile;
		this.org = org;
		this.key = key;
		this.orgId = orgId;
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
	public String getOrgId() {
		return orgId;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into user values"+"("+"'"+id+"','"+password+"','"+name+"','"+mobile+"',"+juri.ordinal()+","+key+",null,null,0,0,0)";break;
		case DELETE:command="delete from user where id='"+id+"'";break;
		case FIND:
			if(name != null){
				command="select * from user where id like %"+id+"% or name like %"+name+"% or juri="+juri.ordinal()+" or org like %"+org+"%";
			} else {
				command = "select * from user where id = '"+id+"'";
			}
			break;
		case UPDATE:command="update user set id='"+id+"' password='"+password+"' name='"+name+"' mobile='"+mobile+"' juri="+juri.ordinal()+" orgId='"+orgId+"' where keyid="+key;break;
		}
		return command;
	}
}
