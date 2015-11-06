package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.po.enums.GoodState;

public class ArrivePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8474934805502655478L;
	private String centerId;
	private Calendar date;
	private String id;
	private String startPlace;
	private GoodState state;
	private Calendar opTime;
	public ArrivePO(String centerId, Calendar date, String id, String startPlace,
			GoodState state, Calendar opTime) {
		super();
		this.centerId = centerId;
		this.date = date;
		this.id = id;
		this.startPlace = startPlace;
		this.state = state;
		this.opTime = opTime;
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
	public Calendar getOpTime() {
		return opTime;
	}
}
