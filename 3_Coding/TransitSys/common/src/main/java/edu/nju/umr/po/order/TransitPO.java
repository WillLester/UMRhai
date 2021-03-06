package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.po.order.function.GetToday;
import edu.nju.umr.po.order.function.KindGetter;
import edu.nju.umr.po.order.function.LocationFind;
import edu.nju.umr.po.order.function.OrderOper;
import edu.nju.umr.po.order.function.UpdateTranState;

public class TransitPO extends PO implements Serializable,KindGetter,OrderOper,GetToday,UpdateTranState,LocationFind{
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
	private String userId;
	private Transit transit;
	private boolean isArrived;
	private String startOrgId;
	
	public TransitPO(String id, String planeId, String startPlace,
			String arrivePlace, String containerId, String supervision,
			ArrayList<String> express, Calendar date, Calendar opTime,
			String opName, double cost,String userId,Transit transit,boolean isArrived,String startOrgId) {
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
		this.userId = userId;
		this.transit = transit;
		this.isArrived = isArrived;
		this.startOrgId=startOrgId;
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
	public String getUserId() {
		return userId;
	}
	public Transit getTransit() {
		return transit;
	}
	public boolean isArrived() {
		return isArrived;
	}
	public String getStartOrgId(){
		return startOrgId;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		
		switch(op){
		case INSERT:
			String text = "";
			for(String ex:express){
				text = text + ex + " ";
			}
			command="insert into transitorderwaiting values"+"("+"'"+id+"','"+planeId+"','"+startPlace+"','"
		+arrivePlace+"','"+containerId+"','"+supervision+"','"+DateFormat.DATE.format(date.getTime())+"','"+
				DateFormat.TIME.format(opTime.getTime())+"','"+opName+"',"+cost+",'"+text+"','"+userId+"',"+
		transit.ordinal()+","+isArrived+",'"+startOrgId+"')";break;
		case DELETE:break;
		case FIND:command="select * from transitorderpassed where id='"+id+"'";break;
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
			return "insert into transitorderpassed select * from transitorderwaiting where id='"+id+"'";
		} else {
			return "insert into transitorderunpassed select * from transitorderwaiting where id='"+id+"'";
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
	@Override
	public String getUnpassed() {
		// TODO 自动生成的方法存根
		return "select * from transitorderunpassed where userId='"+userId+"'";
	}
	@Override
	public String getToday() {
		// TODO 自动生成的方法存根
		return "select * from transitorderwaiting where id like '%"+id+"%' union "
				+ "select * from transitorderpassed where id like '%"+id+"%' union "
				+ "select * from transitorderunpassed where id like '%"+id+"%'";
	}
	@Override
	public String getOrdersHere() {
		// TODO 自动生成的方法存根
		if(startPlace == null){
			return "select id from transitorderpassed where arrivePlace = '"+arrivePlace+"' and isArrived = "+isArrived;
		} else {
			return "select id from transitorderpassed where startPlace = '"+startPlace+"' and isArrived = "+isArrived;
		}
	}
	@Override
	public String getUpdateTran() {
		// TODO 自动生成的方法存根
		return "update transitorderpassed set isArrived = "+isArrived+" where id = '"+id+"'";
	}
}
