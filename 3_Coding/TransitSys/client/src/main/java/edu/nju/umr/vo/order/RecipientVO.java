package edu.nju.umr.vo.order;

import java.util.Calendar;

import edu.nju.umr.po.enums.GoodState;

public class RecipientVO {
	private Calendar date;
//	private String id;
	private String transitId;
	private String startPlace;
	private GoodState state;
	private String opName;
	private String userId;

	public RecipientVO(Calendar date,String transitId,String startPlace,GoodState state,String opName,String userId) {
		// TODO 自动生成的构造函数存根
		this.date = date;
//		this.id = id;
		this.transitId = transitId;
		this.startPlace = startPlace;
		this.state = state;
		this.opName=opName;
		this.userId = userId;
	}
	public Calendar getDate() {
		return date;
	}
//	public String getId() {
//		return id;
//	}
	public String getTransitId() {
		return transitId;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public GoodState getState() {
		return state;
	}
	public String getOpName() {
		return opName;
	}
	public String getUserId() {
		return userId;
	}
}
