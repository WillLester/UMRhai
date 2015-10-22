package edu.nju.umr.vo;

public class ResultMessage {
	private boolean isSuccessful;
	private Object Message;
	public boolean isSuccessful() {
		return isSuccessful;
	}
	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}
	public Object getMessage() {
		return Message;
	}
	public void setMessage(Object message) {
		Message = message;
	}
}
