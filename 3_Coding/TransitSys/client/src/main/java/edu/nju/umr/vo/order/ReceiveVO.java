package edu.nju.umr.vo.order;

import java.util.Date;

public class ReceiveVO {
	private String expressId;
	private String receiver;
	private Date date;
	public ReceiveVO(String expressId,String receiver,Date date) {
		// TODO 自动生成的构造函数存根
		this.expressId = expressId;
		this.receiver = receiver;
		this.date = date;
	}
	public String getExpressId() {
		return expressId;
	}
	public String getReceiver() {
		return receiver;
	}
	public Date getDate() {
		return date;
	}
	
}
