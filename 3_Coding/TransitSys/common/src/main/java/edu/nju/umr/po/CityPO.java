package edu.nju.umr.po;

import java.io.Serializable;

import edu.nju.umr.po.enums.MysqlOperation;

public class CityPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7528731479676963784L;
	private String name;
	private String id;
	private String province;
	private int key;
	
	public CityPO(String name, String id, String province,int key) {
		super();
		this.name = name;
		this.id = id;
		this.province = province;
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getProvince() {
		return province;
	}
	public int getKey() {
		return key;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into city values"+"('"+id+"',"+"'"+name+"','"+province+"',"+key+")";break;
		case DELETE:command="delete from city where name='"+name+"'";break;
		case FIND:break;
		case UPDATE:command = "update city set id='"+id+"',name='"+name+"',province='"+province+"' where keyid="+key;break;
		}
		return command;
	}
	
}
