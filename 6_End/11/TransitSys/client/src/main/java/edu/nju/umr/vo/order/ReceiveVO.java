package edu.nju.umr.vo.order;

import java.util.Calendar;

public class ReceiveVO{
	private String realReceiver;
	private Calendar receiveTime;
	public ReceiveVO(String realReceiver,Calendar receiveTime) {
		// TODO 自动生成的构造函数存根
		this.realReceiver = realReceiver;
		this.receiveTime = receiveTime;
	}
	public String getRealReceiver() {
		return realReceiver;
	}
	public Calendar getReceiveTime() {
		return receiveTime;
	}

}
