package edu.nju.umr.vo;

import edu.nju.umr.po.enums.Part;

public class ShelfVO {
	private String id;
	private int row;
	private int place;
	private Part part;
	public ShelfVO(String id,int row,int place,Part part) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.row = row;
		this.place = place;
		this.part = part;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
}
