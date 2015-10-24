package edu.nju.umr.vo;

import java.util.Date;

public class DiaryVO {
	private String operation;
	private Date time;
	public DiaryVO(String operation,Date time) {
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
