package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import edu.nju.umr.po.enums.GoodState;

public class RecipientPO implements Serializable{
	private Date date;
	private String id;
	private String transitId;
	private String startPlace;
	private GoodState state;
	private Calendar opTime;
	
	public RecipientPO(Date date, String id, String transitId,
			String startPlace, GoodState state, Calendar opTime) {
		super();
		this.date = date;
		this.id = id;
		this.transitId = transitId;
		this.startPlace = startPlace;
		this.state = state;
		this.opTime = opTime;
	}
	public Date getDate() {
		return date;
	}
	public String getId() {
		return id;
	}
	public String getTransitId() {
		return transitId;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public GoodState getState() {
		return state;
	}
	public Calendar getOpTime() {
		return opTime;
	}
}
