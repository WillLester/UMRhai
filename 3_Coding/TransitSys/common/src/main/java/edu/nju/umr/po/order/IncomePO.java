package edu.nju.umr.po.order;

import java.util.ArrayList;
import java.util.Date;

public class IncomePO{
	private Date date;
	private String courier;
	private double cost;
	private ArrayList<String> express;
	private String id;
	public IncomePO(Date date,String courier,double cost,ArrayList<String> express,String id) {
		// TODO 自动生成的构造函数存根
		this.date = date;
		this.courier = courier;
		this.cost = cost;
		this.express = express;
		this.id = id;
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
}
