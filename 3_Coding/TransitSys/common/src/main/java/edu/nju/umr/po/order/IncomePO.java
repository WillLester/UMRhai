package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;

public class IncomePO extends PO implements Serializable{
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
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into incomeorderwaiting values"+"("+id+",'"+courier+"',"+cost+",'"+DateFormat.DATE.format(date.getTime())+"',"+DateFormat.TIME.format(opTime.getTime())+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
}
