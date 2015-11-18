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
	
}
