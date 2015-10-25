package edu.nju.umr.po;

import java.io.Serializable;

import edu.nju.umr.po.enums.Organization;

public class OrgPO implements Serializable{
	private String id;
	private String name;
	private Organization kind;
	private String location;
	private CityPO city;
	public OrgPO(String id,String name,Organization kind,String location,CityPO city) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.name = name;
		this.kind = kind;
		this.location = location;
		this.city = city;
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
	public CityPO getCity() {
		return city;
	}
}
