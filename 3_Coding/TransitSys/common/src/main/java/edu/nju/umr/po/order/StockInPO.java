package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import edu.nju.umr.po.enums.Part;

public class StockInPO implements Serializable{
	private String id;
	private String expressId;
	private Date date;
	private String arrivePlace;
	private Part part;
	private String shelfId;
	private int row;
	private int place;
	private Calendar opTime;
	
	public StockInPO(String id, String expressId, Date date,
			String arrivePlace, Part part, String shelfId, int row, int place,
			Calendar opTime) {
		super();
		this.id = id;
		this.expressId = expressId;
		this.date = date;
		this.arrivePlace = arrivePlace;
		this.part = part;
		this.shelfId = shelfId;
		this.row = row;
		this.place = place;
		this.opTime = opTime;
	}
	public String getId() {
		return id;
	}
	public String getExpressId() {
		return expressId;
	}
	public Date getDate() {
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
	public Calendar getOpTime() {
		return opTime;
	}
}
