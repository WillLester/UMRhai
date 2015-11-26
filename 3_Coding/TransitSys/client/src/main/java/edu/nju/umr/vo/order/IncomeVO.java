package edu.nju.umr.vo.order;

import java.util.ArrayList;
import java.util.Calendar;

public class IncomeVO {
	private Calendar date;
	private String courier;
	private double cost;
	private ArrayList<String> express;
//	private String id;
//	private Calendar opTime;
	private String opName;
	private String orgId;
	public IncomeVO(Calendar date,String courier,double cost,ArrayList<String> express,String opName,String orgId) {
		// TODO 自动生成的构造函数存根
		this.date = date;
		this.courier = courier;
		this.cost = cost;
		this.express = express;
//		this.id = id;
		this.opName = opName;
		this.orgId = orgId;
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
//	public String getId() {
//		return id;
//	}
	public String getOpName() {
		return opName;
	}
	
	public String getOrgId() {
		return orgId;
	}
}
