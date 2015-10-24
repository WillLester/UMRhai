package edu.nju.umr.po.order;

import java.util.Date;

import edu.nju.umr.po.enums.Transit;

public class StockOutPO {
	private String id;
	private String expressId;
	private Date date;
	private Transit kind;
	private String transitId;
	public StockOutPO(String id,String expressId,Date date,Transit kind,String transitId) {
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
	public Date getDate() {
		return date;
	}
	public Transit getKind() {
		return kind;
	}
	public String getTransitId() {
		return transitId;
	}
}
