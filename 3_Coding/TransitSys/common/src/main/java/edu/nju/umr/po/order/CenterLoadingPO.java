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
import edu.nju.umr.po.order.function.LocationFind;
import edu.nju.umr.po.order.function.OrderOper;
import edu.nju.umr.po.order.function.UpdateTranState;

public class CenterLoadingPO extends PO implements Serializable,KindGetter,OrderOper,GetToday,UpdateTranState,LocationFind{
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
	private boolean isArrived;
	private String startPlace;
	private String startOrgId;
	
	public CenterLoadingPO(Calendar date, String id, String target,
			String vanId, String supervision, String escort,
			ArrayList<String> express, Calendar opTime, String opName,double cost,String userId,
			boolean isArrived,String startPlace,String startOrgId) {
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
		this.isArrived = isArrived;
		this.startPlace = startPlace;
		this.startOrgId = startOrgId;
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
	public boolean isArrived() {
		return isArrived;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public String getStartOrgId() {
		return startOrgId;
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
			command="insert into centerlorderwaiting values"+"("+"'"+id+"','"+target+"','"+vanId+"','"+supervision+"','"+escort+"','"+DateFormat.DATE.format(date.getTime())+"','"+
		DateFormat.TIME.format(opTime.getTime())+"','"+text+"',"+cost+",'"+opName+"','"+userId+"',"+isArrived+",'"+startPlace+"','"+startOrgId+"')";break;
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
		return "delete from centerlorderunpassed where id='"+id+"'";
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
	@Override
	public String getToday() {
		// TODO 自动生成的方法存根
		return "select * from centerlorderwaiting where id like '%"+id+"%' union "
				+ "select * from centerlorderpassed where id like '%"+id+"%' union "
				+ "select * from centerlorderunpassed where id like '%"+id+"%'";
	}
	@Override
	public String getOrdersHere() {
		// TODO 自动生成的方法存根
		if(startPlace == null){
			return "select id from centerlorderpassed where target = '"+target+"' and isArrived = "+isArrived;
		} else {
			return "select id from centerlorderpassed where startPlace = '"+startPlace+"' and isArrived = "+isArrived;
		}
	}
	@Override
	public String getUpdateTran() {
		// TODO 自动生成的方法存根
		return "update centerlorderpassed set isArrived = "+isArrived +" where id = '"+id+"'";
	}
	
}
