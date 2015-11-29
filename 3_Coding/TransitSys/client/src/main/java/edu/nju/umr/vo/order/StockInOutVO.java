package edu.nju.umr.vo.order;

import java.util.Calendar;

public class StockInOutVO {
	private Calendar time;
	private String type;
	private String expressId;
	private String shelfId;
	private int row;
	private int place;

	
	public StockInOutVO(Calendar time, String type, String expressId, String shelfId, int row, int place){
		this.time = time;
		this.type = type;
		this.expressId = expressId;
		this.shelfId = shelfId;
		this.row = row;
		this.place = place;
	}


	public Calendar getTime() {
		return time;
	}


	public String getType() {
		return type;
	}


	public String getExpressId() {
		return expressId;
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
