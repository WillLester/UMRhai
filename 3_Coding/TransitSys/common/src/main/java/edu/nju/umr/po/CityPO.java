package edu.nju.umr.po;

import java.io.Serializable;

public class CityPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7528731479676963784L;
	private String name;
	private String id;
	private String province;
	
	public CityPO(String name, String id, String province) {
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
