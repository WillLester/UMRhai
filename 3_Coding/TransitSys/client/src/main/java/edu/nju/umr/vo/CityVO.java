package edu.nju.umr.vo;

public class CityVO {
	private String name;
	private String id;
	public CityVO(String name,String id) {
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
