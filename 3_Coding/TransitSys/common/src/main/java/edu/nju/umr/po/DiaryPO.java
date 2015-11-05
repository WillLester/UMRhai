package edu.nju.umr.po;

import java.io.Serializable;
import java.util.Date;

public class DiaryPO implements Serializable{
	private String operation;
	private Date time;
	private String operator;
	
	public DiaryPO(String operation, Date time, String operator) {
		super();
		this.operation = operation;
		this.time = time;
		this.operator = operator;
	}
	public String getOperation() {
		return operation;
	}
	public Date getTime() {
		return time;
	}
	public String getOperator() {
		return operator;
	}
}
