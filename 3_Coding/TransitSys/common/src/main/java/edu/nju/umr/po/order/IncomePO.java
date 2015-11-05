package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class IncomePO implements Serializable{
	private Date date;
	private String courier;
	private double cost;
	private ArrayList<String> express;
	private String id;
	private Calendar opTime;
	
	public IncomePO(Date date, String courier, double cost,
			ArrayList<String> express, String id, Calendar opTime) {
		super();
		this.date = date;
		this.courier = courier;
		this.cost = cost;
		this.express = express;
		this.id = id;
		this.opTime = opTime;
	}
	public Date getDate() {
		return date;
	}
	public String getCourier() {
		return courier;
	}
	public double getCost() {
		return cost;
	}
	public ArrayList<String> getExpress() {
		return express;
	}
	public String getId() {
		return id;
	}
	public Calendar getOpTime() {
		return opTime;
	}
}
