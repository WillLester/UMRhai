package edu.nju.umr.vo.order;

import java.util.ArrayList;
import java.util.Calendar;

public class TransitVO {
//	private String id;
	private String planeId;
	private String startPlace;
	private String arrivePlace;
	private String containerId;
	private String supervision;
	private ArrayList<String> express;
	private String opName;
	private double cost;
	private Calendar date;
	
	public TransitVO(String planeId, String startPlace, String arrivePlace,
			String containerId, String supervision, ArrayList<String> express,Calendar date,
			String opName, double cost) {
		super();
		this.planeId = planeId;
		this.startPlace = startPlace;
		this.arrivePlace = arrivePlace;
		this.containerId = containerId;
		this.supervision = supervision;
		this.express = express;
		this.opName = opName;
		this.cost = cost;
		this.date=date;
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
	
}
