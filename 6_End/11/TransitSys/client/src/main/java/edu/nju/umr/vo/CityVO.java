package edu.nju.umr.vo;

public class CityVO {
	private String name;
	private String id;
	private String province;
	
	public CityVO(String name, String id, String province) {
		super();
		this.name = name;
		this.id = id;
		this.province = province;
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
}
