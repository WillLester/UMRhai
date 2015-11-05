package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class SendPO implements Serializable{
	private Date date;
	private String expressId;
	private String id;
	private String courier;
	private Calendar opTime;
	
	public SendPO(Date date, String expressId, String id, String courier,
			Calendar opTime) {
		super();
		this.date = date;
		this.expressId = expressId;
		this.id = id;
		this.courier = courier;
		this.opTime = opTime;
	}
	public Date getDate() {
		return date;
	}
	public String getExpressId() {
		return expressId;
	}
	public String getId() {
		return id;
	}
	public String getCourier() {
		return courier;
	}
	public Calendar getOpTime() {
		return opTime;
	}
}
