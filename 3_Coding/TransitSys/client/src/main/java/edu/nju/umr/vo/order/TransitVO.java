package edu.nju.umr.vo.order;

import java.util.ArrayList;
import java.util.Calendar;

public class TransitVO {
	private String id;
	private String planeId;
	private String startPlace;
	private String arrivePlace;
	private String containerId;
	private String supervision;
	private ArrayList<String> express;
	private String opName;
	private double cost;
	private Calendar date;
	private String userId;

	public TransitVO(String id, String planeId, String startPlace,
			String arrivePlace, String containerId, String supervision,
			ArrayList<String> express, String opName, double cost, Calendar date,String userId) {
		super();
		this.id = id;
		this.planeId = planeId;
		this.startPlace = startPlace;
		this.arrivePlace = arrivePlace;
		this.containerId = containerId;
		this.supervision = supervision;
		this.express = express;
		this.opName = opName;
		this.cost = cost;
		this.date = date;
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public double getCost() {
		return cost;
	}

	public String getPlaneId() {
		return planeId;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public String getArrivePlace() {
		return arrivePlace;
	}
	public String getContainerId() {
		return containerId;
	}
	public String getSupervision() {
		return supervision;
	}
	public ArrayList<String> getExpress() {
		return express;
	}
	public String getOpName() {
		return opName;
	}
	public Calendar getDate(){
		return date;
	}

	public String getUserId() {
		return userId;
	}
	
}
