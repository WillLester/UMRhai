package edu.nju.umr.vo.order;

import java.util.Calendar;

import edu.nju.umr.po.enums.Part;

public class StockInVO {
//	private String id;
	private String expressId;
	private Calendar date;
	private String arrivePlace;
	private Part part;
	private String shelfId;
	private int row;
	private int place;
	public StockInVO(String expressId,Calendar date,String arrivePlace,Part part,String shelfId,int row,int place) {
		// TODO 自动生成的构造函数存根
//		this.id = id;
		this.expressId = expressId;
		this.date = date;
		this.arrivePlace = arrivePlace;
		this.part = part;
		this.shelfId = shelfId;
		this.row = row;
		this.place = place;
	}
//	public String getId() {
//		return id;
//	}
	public String getExpressId() {
		return expressId;
	}
	public Calendar getDate() {
		return date;
	}
	public String getArrivePlace() {
		return arrivePlace;
	}
	public Part getPart() {
		return part;
	}
	public String getShelfId() {
		return shelfId;
	}
	public int getRow() {
		return row;
	}
	public int getPlace() {
		return place;
	}
	
}
