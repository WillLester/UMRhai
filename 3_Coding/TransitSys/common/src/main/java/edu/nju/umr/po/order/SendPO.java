package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Date;

public class SendPO implements Serializable{
	private Date date;
	private String expressId;
	private String id;
	private String courier;
	public SendPO(Date date,String expressId,String id,String name) {
		// TODO 自动生成的构造函数存根
		this.date = date;
		this.expressId = expressId;
		this.id = id;
		this.courier = name;
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
}
