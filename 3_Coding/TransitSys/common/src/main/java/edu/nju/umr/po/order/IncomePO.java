package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class IncomePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1315709059088122485L;
	private Calendar date;
	private String courier;
	private double cost;
	private ArrayList<String> express;
	private String id;
	private Calendar opTime;
	
	public IncomePO(Calendar date, String courier, double cost,
			ArrayList<String> express, String id, Calendar opTime) {
		super();
		this.date = date;
		this.courier = courier;
		this.cost = cost;
		this.express = express;
		this.id = id;
		this.opTime = opTime;
	}
	public Calendar getDate() {
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
