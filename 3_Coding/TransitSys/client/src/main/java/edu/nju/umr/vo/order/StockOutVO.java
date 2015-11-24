package edu.nju.umr.vo.order;

import java.util.Calendar;

import edu.nju.umr.po.enums.Transit;

public class StockOutVO {
//	private String id;
	private String expressId;
	private Calendar date;
	private Transit kind;
	private String transitId;
	private String opName;
	private String stockId;
	public StockOutVO(String expressId,Calendar date,Transit kind,String transitId,String opName,String stockId) {
		// TODO 自动生成的构造函数存根
//		this.id = id;
		this.expressId = expressId;
		this.date = date;
		this.kind = kind;
		this.transitId = transitId;
		this.opName=opName;
		this.stockId = stockId;
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
}
