package edu.nju.umr.po;

import java.io.Serializable;
import java.util.Date;

import edu.nju.umr.po.enums.Part;

public class GoodPO implements Serializable{
	private String id;
	private String stockId;
	private Date date;
	private String city;
	private Part part;
	private String shelf;
	private int row;
	private int place;

	public GoodPO(String id, String stockId, Date date, String city, Part part,
			String shelf, int row, int place) {
		super();
		this.id = id;
		this.stockId = stockId;
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
	public String getStockId() {
		return stockId;
	}
}
