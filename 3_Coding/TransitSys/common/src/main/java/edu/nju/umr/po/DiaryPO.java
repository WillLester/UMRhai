package edu.nju.umr.po;

import java.io.Serializable;
import java.util.Date;

public class DiaryPO implements Serializable{
	private String operation;
	private Date time;
	public DiaryPO(String operation,Date time) {
		// TODO 自动生成的构造函数存根
		this.operation = operation;
		this.time = time;
	}
	public String getOperation() {
		return operation;
	}
	public Date getTime() {
		return time;
	}
}
