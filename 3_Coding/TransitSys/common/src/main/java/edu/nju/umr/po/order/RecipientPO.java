package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.po.enums.GoodState;

public class RecipientPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1377652016004151729L;
	private Calendar date;
	private String id;
	private String transitId;
	private String startPlace;
	private GoodState state;
	private Calendar opTime;
	
	public RecipientPO(Calendar date, String id, String transitId,
			String startPlace, GoodState state, Calendar opTime) {
		super();
		this.date = date;
		this.id = id;
		this.transitId = transitId;
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
