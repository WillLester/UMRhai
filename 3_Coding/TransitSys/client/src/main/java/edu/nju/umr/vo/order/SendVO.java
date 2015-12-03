package edu.nju.umr.vo.order;

import java.util.Calendar;

public class SendVO {
	private Calendar date;
	private String expressId;
//	private String id;
	private String courier;
	private String opName;
	private String userId;
	public SendVO(Calendar date,String expressId,String courier,String opName,String userId) {
		// TODO 自动生成的构造函数存根
		this.date = date;
		this.expressId = expressId;
//		this.id = id;
		this.courier = courier;
		this.opName = opName;
		this.userId = userId;
	}
	public Calendar getDate() {
		return date;
	}
	public String getExpressId() {
		return expressId;
	}
//	public String getId() {
//		return id;
//	}
	public String getCourier() {
		return courier;
	}
	public String getOpName() {
		return opName;
	}
	public String getUserId() {
		return userId;
	}
}
