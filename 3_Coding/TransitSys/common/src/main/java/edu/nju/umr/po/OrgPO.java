package edu.nju.umr.po;

import java.io.Serializable;

import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Organization;

public class OrgPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8665604375936596624L;
	private String id;
	private String name;
	private Organization kind;
	private String location;
	private String city;
	private String cityId;
	
	public OrgPO(String id, String name, Organization kind, String location,
			String city, String cityId) {
		super();
		this.id = id;
		this.name = name;
		this.kind = kind;
		this.location = location;
		this.city = city;
		this.cityId = cityId;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Organization getKind() {
		return kind;
	}
	public String getLocation() {
		return location;
	}
	
	public String getCity() {
		return city;
	}
	public String getCityId() {
		return cityId;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into org values"+"("+"'"+id+"','"+name+"',"+kind.ordinal()+",'"+location+"','"+city+"','"+cityId+"'"+")";break;
		case DELETE:command="delete from org where id='"+id+"'";break;
		case FIND:command="select * from org where id like %"+id+"% or name like %"+name+"% or city like %"+city+"% or kind="+kind.ordinal();break;
		case UPDATE:command="update org set name = '"+name+"',kind ="+kind.ordinal()+",location='"+location+"',city='"+city+"',cityId='"+cityId+"' where id='"+id+"'";break;
		}
		return command;
	}
}
