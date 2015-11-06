package edu.nju.umr.po;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.po.enums.Part;

public class GoodPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5450228488458252337L;
	private String id;
	private String stockId;
	private Calendar date;
	private String city;
	private Part part;
	private String shelf;
	private int row;
	private int place;

	public GoodPO(String id, String stockId, Calendar date, String city, Part part,
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
	public Calendar getDate() {
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
