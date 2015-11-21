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
	private int id;
	private Calendar opTime;
	private String opName;
	
	public IncomePO(Calendar date, String courier, double cost,
			ArrayList<String> express, int id, Calendar opTime, String opName) {
		super();
		this.date = date;
		this.courier = courier;
		this.cost = cost;
		this.express = express;
		this.id = id;
		this.opTime = opTime;
		this.opName = opName;
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
	public int getId() {
		return id;
	}
	public Calendar getOpTime() {
		return opTime;
	}
	public String getOpName() {
		return opName;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:
			String text = "";
			for(String exp:express){
				text = text + exp + " ";
			}
			command="insert into incomeorderwaiting values"+"("+id+",'"+courier+"',"+cost+",'"+DateFormat.DATE.format(date.getTime())+"',"+DateFormat.TIME.format(opTime.getTime())+",'"+text+"','"+opName+"')";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
}
