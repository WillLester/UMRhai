package edu.nju.umr.vo.order;

import java.util.Calendar;

import edu.nju.umr.po.enums.GoodState;

public class ArriveVO {
	private String centerId;
	private Calendar date;
	private String id;
	private String startPlace;
	private GoodState state;
	private String opName;
	private String userId;
	
	public ArriveVO(String centerId, Calendar date, String id,
			String startPlace, GoodState state, String opName, String userId) {
		super();
		this.centerId = centerId;
		this.date = date;
		this.id = id;
		this.startPlace = startPlace;
		this.state = state;
		this.opName = opName;
		this.userId = userId;
	}

	public Calendar getDate() {
		return date;
	}
	public String getId() {
		return id;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public GoodState getState() {
		return state;
	}
	public String getCenterId() {
		return centerId;
	}
	public String getOpName() {
		return opName;
	}
	public String getUserId() {
		return userId;
	}
	
}
