package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;

public class CenterLoadingPO extends PO implements Serializable,OrderOper{
	/**
	 * 
	 */
	private static final long serialVersionUID = 113757402410628188L;
	private Calendar date;
	private String id;
	private String target;
	private String vanId;
	private String supervision;
	private String escort;
	private ArrayList<String> express;
	private Calendar opTime;
	private String opName;
	private double cost;
	
	public CenterLoadingPO(Calendar date, String id, String target,
			String vanId, String supervision, String escort,
			ArrayList<String> express, Calendar opTime, String opName,double cost) {
		super();
		this.date = date;
		this.id = id;
		this.target = target;
		this.vanId = vanId;
		this.supervision = supervision;
		this.escort = escort;
		this.express = express;
		this.opTime = opTime;
		this.opName = opName;
		this.cost=cost;
	}
	public Calendar getDate() {
		return date;
	}
	public String getTarget() {
		return target;
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
	public String getId() {
		return id;
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
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into centerlorderwaiting values"+"("+"'"+id+"','"+target+"','"+vanId+"','"+supervision+"','"+escort+"','"+DateFormat.DATE.format(date.getTime())+"','"+DateFormat.TIME.format(opTime.getTime())+"','"+opName+"',"+cost+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	@Override
	public Order getOrderKind() {
		// TODO 自动生成的方法存根
		return Order.CENTERLOADING;
	}
	@Override
	public String getApprove(boolean isPassed) {
		// TODO 自动生成的方法存根
		if(isPassed){
			return "insert into centerlorderpassed from centerlorderwaiting where id='"+id+"'";
		} else {
			return "insert into centerlorderunpassed from centerlorderwaiting where id='"+id+"'";
		}
	}
	@Override
	public String getDeleteWaiting() {
		// TODO 自动生成的方法存根
		return "delete from centerlorderwaiting where id='"+id+"'";
	}
	@Override
	public String getDeleteUnpassed() {
		// TODO 自动生成的方法存根
		return "delete from centerlorderunpassed where id='"+id+"'";
	}
	
}
