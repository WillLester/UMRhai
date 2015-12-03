package edu.nju.umr.vo.order;

import java.util.ArrayList;
import java.util.Calendar;

public class CenterLoadingVO {
	private Calendar date;
	private String transitId;
	private String target;
	private String vanId;
	private String supervision;
	private String escort;
	private ArrayList<String> express;
	private double cost;
	private String opName;
	private String userId;
	
	public CenterLoadingVO(Calendar date, String transitId, String target,
			String vanId, String supervision, String escort,
			ArrayList<String> express, double cost, String opName, String userId) {
		super();
		this.date = date;
		this.transitId = transitId;
		this.target = target;
		this.vanId = vanId;
		this.supervision = supervision;
		this.escort = escort;
		this.express = express;
		this.cost = cost;
		this.opName = opName;
		this.userId = userId;
	}
	public Calendar getDate() {
		return date;
	}
	public String getTarget() {
		return target;
	}
	public String getVanId() {
		return vanId;
	}
	public String getSupervision() {
		return supervision;
	}
	public String getEscort() {
		return escort;
	}
	public ArrayList<String> getExpress() {
		return express;
	}
	public double getCost(){
		return cost;
	}
	public String getOpName() {
		return opName;
	}
	public String getTransitId() {
		return transitId;
	}
	public String getUserId() {
		return userId;
	}
	
}
