package edu.nju.umr.po;

import edu.nju.umr.po.enums.Part;

public class ShelfPO {
	private String id;
	private int row;
	private int place;
	private Part part;
	public ShelfPO(String id,int row,int place,Part part) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.row = row;
		this.place = place;
		this.part = part;
	}
	public String getId() {
		return id;
	}
	public int getRow() {
		return row;
	}
	public int getPlace() {
		return place;
	}
	public Part getPart() {
		return part;
	}
}
