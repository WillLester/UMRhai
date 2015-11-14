package edu.nju.umr.vo;

import edu.nju.umr.po.enums.Result;

public class ResultMessage {
	private Result reInfo;
	private Object message;
	
	public ResultMessage(Result reInfo, Object message) {
		super();
		this.reInfo = reInfo;
		this.message = message;
	}
	
	public Result getReInfo() {
		return reInfo;
	}

	public Object getMessage() {
		return message;
	}
}
