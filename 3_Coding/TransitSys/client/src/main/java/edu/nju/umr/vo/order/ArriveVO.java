package edu.nju.umr.vo.order;

import java.util.Date;

import edu.nju.umr.po.enums.GoodState;

public class ArriveVO {
	private String centerId;
	private Date date;
	private String id;
	private String startPlace;
	private GoodState state;
	public ArriveVO(String centerId,Date date,String id,String startPlace,GoodState state) {
		// TODO 自动生成的构造函数存根
		this.centerId = centerId;
		this.date = date;
		this.id = id;
		this.startPlace = startPlace;
		this.state = state;
	}
	public Date getDate() {
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
	
}
