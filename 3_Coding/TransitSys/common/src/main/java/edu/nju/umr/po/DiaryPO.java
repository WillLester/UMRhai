package edu.nju.umr.po;

import java.io.Serializable;
import java.util.Calendar;

public class DiaryPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1403096551316019080L;
	private String operation;
	private Calendar time;
	private String operator;
	
	public DiaryPO(String operation, Calendar time, String operator) {
		super();
		this.operation = operation;
		this.time = time;
		this.operator = operator;
	}
	public String getOperation() {
		return operation;
	}
	public Calendar getTime() {
		return time;
	}
	public String getOperator() {
		return operator;
	}
}
