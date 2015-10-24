package edu.nju.umr.vo;

import edu.nju.umr.po.enums.Organization;

public class OrgVO {
	private String id;
	private String name;
	private Organization kind;
	private String location;
	private CityVO city;
	public OrgVO(String id,String name,Organization kind,String location,CityVO city) {
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
	public CityVO getCity() {
		return city;
	}
}
