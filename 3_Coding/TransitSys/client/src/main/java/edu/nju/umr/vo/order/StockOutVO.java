package edu.nju.umr.vo.order;

import java.util.Calendar;

import edu.nju.umr.po.enums.Transit;

public class StockOutVO {
//	private String id;
	private String expressId;
	private Calendar date;
	private Transit kind;
	private String arrivePlace;
	private String transitId;
	private String opName;
	private String stockId;
	private String userId;
	
	public StockOutVO(String expressId, Calendar date, Transit kind,
			String arrivePlace, String transitId, String opName, String stockId,String userId) {
		super();
		this.expressId = expressId;
		this.date = date;
		this.kind = kind;
		this.arrivePlace = arrivePlace;
		this.transitId = transitId;
		this.opName = opName;
		this.stockId = stockId;
		this.userId = userId;
	}
	public String getStockId() {
		return stockId;
	}
	public String getExpressId() {
		return expressId;
	}
	public Calendar getDate() {
		return date;
	}
	public Transit getKind() {
		return kind;
	}
	public String getTransitId() {
		return transitId;
	}
	public String getOpName() {
		return opName;
	}
	public String getArrivePlace() {
		return arrivePlace;
	}
	public String getUserId() {
		return userId;
	}
}
