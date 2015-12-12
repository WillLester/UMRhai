package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.order.function.KindGetter;
import edu.nju.umr.po.order.function.OrderOper;

public class CenterLoadingPO extends PO implements Serializable,KindGetter,OrderOper{
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
	private String userId;
	
	public CenterLoadingPO(Calendar date, String id, String target,
			String vanId, String supervision, String escort,
			ArrayList<String> express, Calendar opTime, String opName,double cost,String userId) {
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
		this.userId = userId;
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
	public String getUserId() {
		return userId;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into centerlorderwaiting values"+"("+"'"+id+"','"+target+"','"+vanId+"','"+supervision+"','"+escort+"','"+DateFormat.DATE.format(date.getTime())+"','"+
		DateFormat.TIME.format(opTime.getTime())+"','"+opName+"',"+cost+",'"+userId+"')";break;
		case DELETE:break;
		case FIND:command="select * from centerlorderpassed where id='"+id+"'";break;
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
			return "insert into centerlorderpassed select * from centerlorderwaiting where id='"+id+"'";
		} else {
			return "insert into centerlorderunpassed select * from centerlorderwaiting where id='"+id+"'";
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
		return "delete from centerlorderunpassed where userId='"+userId+"'";
	}
	@Override
	public String getDetail() {
		// TODO 自动生成的方法存根
		return "select * from centerlorderwaiting where id ='"+id+"'";
	}
	@Override
	public String getUnpassed() {
		// TODO 自动生成的方法存根
		return "select * from centerlorderunpassed where userId='"+userId+"'";
	}
	
}
