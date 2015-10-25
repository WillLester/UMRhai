package edu.nju.umr.po;

import java.io.Serializable;

public class CityPO implements Serializable{
	private String name;
	private String id;
	public CityPO(String name,String id) {
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
}
