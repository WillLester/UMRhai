package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;

public class TransitPO extends PO implements Serializable,KindGetter,OrderOper{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8545543373940616729L;
	private String id;
	private String planeId;
	private String startPlace;
	private String arrivePlace;
	private String containerId;
	private String supervision;
	private ArrayList<String> express;
	private Calendar date;
	private Calendar opTime;
	private String opName;
	private double cost;
	
	public TransitPO(String id, String planeId, String startPlace,
			String arrivePlace, String containerId, String supervision,
			ArrayList<String> express, Calendar date, Calendar opTime,
			String opName, double cost) {
		super();
		this.id = id;
		this.planeId = planeId;
		this.startPlace = startPlace;
		this.arrivePlace = arrivePlace;
		this.containerId = containerId;
		this.supervision = supervision;
		this.express = express;
		this.date = date;
		this.opTime = opTime;
		this.opName = opName;
		this.cost = cost;
	}
	public String getId() {
		return id;
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
	public Calendar getOpTime() {
		return opTime;
	}
	public String getOpName() {
		return opName;
	}
	public double getCost(){
		return cost;
	}
	public Calendar getDate() {
		return date;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		String text = "";
		for(String ex:express){
			text = text + ex + " ";
		}
		switch(op){
		case INSERT:command="insert into transitorderwaiting values"+"("+"'"+id+"','"+planeId+"','"+startPlace+"','"
		+arrivePlace+"','"+containerId+"','"+supervision+"','"+DateFormat.DATE.format(date)+"','"+DateFormat.TIME.format(opTime.getTime())+"','"+opName+"',"+cost+",'"+text+"')";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	@Override
	public Order getOrderKind() {
		// TODO 自动生成的方法存根
		return Order.TRANSIT;
	}
	@Override
	public String getApprove(boolean isPassed) {
		// TODO 自动生成的方法存根
		if(isPassed){
			return "insert into transitorderpassed from transitorderwaiting where id='"+id+"'";
		} else {
			return "insert into transitorderunpassed from transitorderwaiting where id='"+id+"'";
		}
	}
	@Override
	public String getDeleteWaiting() {
		// TODO 自动生成的方法存根
		return "delete from transitorderwaiting where id='"+id+"'";
	}
	@Override
	public String getDeleteUnpassed() {
		// TODO 自动生成的方法存根
		return "delete from transitorderunpassed where id='"+id+"'";
	}
	@Override
	public String getDetail() {
		// TODO 自动生成的方法存根
		return "select * from transitorderwaiting where id='"+id+"'";
	}
}
