package edu.nju.umr.vo;

public class ResultMessage {
	private boolean isSuccessful;
	private Object message;
	public ResultMessage(boolean isSuccessful,Object message) {
		// TODO 自动生成的构造函数存根
		this.isSuccessful = isSuccessful;
		this.message = message;
	}
	public boolean isSuccessful() {
		return isSuccessful;
	}
	public Object getMessage() {
		return message;
	}
}
