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
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into user values"+"("+"'"+id+"','"+password+"','"+name+"','"+mobile+"','"+org+"',"+juri.ordinal()+","+key+")";break;
		case DELETE:command="delete from user where keyid="+key;break;
		case FIND:break;
		case UPDATE:command="update user set id='"+id+"' password='"+password+"' name='"+name+"' mobile='"+mobile+"' org='"+org+"' juri="+juri.ordinal()+" where keyid="+key;break;
		}
		return command;
	}
}
