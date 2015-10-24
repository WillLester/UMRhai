package edu.nju.umr.po;

import java.util.Date;

import edu.nju.umr.po.enums.Part;

public class GoodPO {
	private String id;
	private Date date;
	private String city;
	private Part part;
	private String shelf;
	private int row;
	private int place;
	public GoodPO(String id,Date date,String city,Part part,String shelf,int row,int place) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.date = date;
		this.city = city;
		this.part = part;
		this.shelf = shelf;
		this.row = row;
		this.place = place;
	}
	public String getId() {
		return id;
	}
	public Date getDate() {
		return date;
	}
	public String getCity() {
		return city;
	}
	public Part getPart() {
		return part;
	}
	public String getShelf() {
		return shelf;
	}
	public int getRow() {
		return row;
	}
	public int getPlace() {
		return place;
	}
}
