package edu.nju.umr.vo.order;

import java.util.Calendar;

import edu.nju.umr.po.enums.Transit;

public class StockOutVO {
	private String id;
	private String expressId;
	private Calendar date;
	private Transit kind;
	private String transitId;
	public StockOutVO(String id,String expressId,Calendar date,Transit kind,String transitId) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.expressId = expressId;
		this.date = date;
		this.kind = kind;
		this.transitId = transitId;
	}
	public String getId() {
		return id;
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
	
}
