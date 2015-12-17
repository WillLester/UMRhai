package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.order.function.GetToday;
import edu.nju.umr.po.order.function.KindGetter;
import edu.nju.umr.po.order.function.OrderOper;

public class HallLoadingPO extends PO implements Serializable,KindGetter,OrderOper,GetToday{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2792959549903355429L;
	private String hallId;
	private String convertId;
	private String arriveLoc;
	private String vanId;
	private String supervision;
	private String escort;
	private ArrayList<String> express;
	private Calendar date;
	private Calendar opTime;
	private String opName;
	private double cost;
	private String userId;
	public HallLoadingPO(String hallId, String convertId,
			String arriveLoc, String vanId, String supervision, String escort,
			ArrayList<String> express, Calendar date, Calendar opTime,
			String opName,double cost,String userId) {
		super();
		this.hallId = hallId;
		this.convertId = convertId;
		this.arriveLoc = arriveLoc;
		this.vanId = vanId;
		this.supervision = supervision;
		this.escort = escort;
		this.express = express;
		this.date = date;
		this.opTime = opTime;
		this.opName = opName;
		this.cost=cost;
		this.userId=userId;
	}
	public String getHallId() {
		return hallId;
	}
	public String getConvertId() {
		return convertId;
	}
	public String getArriveLoc() {
		return arriveLoc;
	}
	public String getVanId() {
		return vanId;
	}
	public String getSupervision() {
		return supervision;
	}
	public String getEscort() {
		return escort;
	}
	public ArrayList<String> getExpress() {
		return express;
	}
	public Calendar getOpTime() {
		return opTime;
	}
	public Calendar getDate() {
		return date;
	}
	public String getOpName() {
		return opName;
	}
	public double getCost(){
		return cost;
	}
	public String getUserId() {
		return userId;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:
			String text = "";
			for(String e:express){
				text = text + e + " ";
			}
			command="insert into halllorderwaiting values"+"("+"'"+hallId+"','"+convertId+"','"+vanId+"','"+arriveLoc+"','"+supervision+"','"+escort+"','"+DateFormat.DATE.format(date.getTime())+"','"+DateFormat.TIME.format(opTime.getTime())+"','"+text+"','"+opName+"',"+cost+",'"+userId+"')";break;
		case DELETE:break;
		case FIND:command = "select * from halllorderpassed where convertId='"+convertId+"'";break;
		case UPDATE:break;
		}
		return command;
	}
	@Override
	public Order getOrderKind() {
		// TODO 自动生成的方法存根
		return Order.HALLLOADING;
	}
	@Override
	public String getApprove(boolean isPassed) {
		// TODO 自动生成的方法存根
		if(isPassed){
			return "insert into halllorderpassed select * from halllorderwaiting where convertId='"+convertId+"'";
		} else {
			return "insert into halllorderunpassed select * from halllorderwaiting where convertId='"+convertId+"'";
		}
	}
	@Override
	public String getDeleteWaiting() {
		// TODO 自动生成的方法存根
		return "delete from halllorderwaiting where convertId='"+convertId+"'";
	}
	@Override
	public String getDeleteUnpassed() {
		// TODO 自动生成的方法存根
		return "delete from halllorderunpassed where convertId ='"+convertId+"'";
	}
	@Override
	public String getDetail() {
		// TODO 自动生成的方法存根
		return "select * from halllorderwaiting where convertId='"+convertId+"'";
	}
	@Override
	public String getUnpassed() {
		// TODO 自动生成的方法存根
		return "select * from halllorderunpassed where userId='"+userId+"'";
	}
	@Override
	public String getToday() {
		// TODO 自动生成的方法存根
		return "select * from halllorderwaiting where convertId like '%"+convertId+"%' union "
				+ "select * from halllorderpassed where convertId like '%"+convertId+"%' union "
				+ "select * from halllorderunpassed where convertId like '%"+convertId+"%'";
	}
	
}
