package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.po.enums.Transit;

public class StockOutPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2102785279404595176L;
	private String id;
	private String expressId;
	private Calendar date;
	private Transit kind;
	private String transitId;
	private Calendar opTime;
	
	public StockOutPO(String id, String expressId, Calendar date, Transit kind,
			String transitId, Calendar opTime) {
		super();
		this.id = id;
		this.expressId = expressId;
		this.date = date;
		this.kind = kind;
		this.transitId = transitId;
		this.opTime = opTime;
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
	public Calendar getOpTime() {
		return opTime;
	}
}
