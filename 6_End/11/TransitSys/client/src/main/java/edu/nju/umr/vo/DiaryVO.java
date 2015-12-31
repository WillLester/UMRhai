package edu.nju.umr.vo;

import java.util.Calendar;

public class DiaryVO {
	private String operation;
	private Calendar time;
	private String operator;
	public DiaryVO(String operator,String operation,Calendar time) {
		// TODO 自动生成的构造函数存根
		this.operator=operator;
		this.operation = operation;
		this.time = time;
	}
	public String getOperator(){
		return operator;
	}
	public String getOperation() {
		return operation;
	}
	public Calendar getTime() {
		return time;
	}
}
