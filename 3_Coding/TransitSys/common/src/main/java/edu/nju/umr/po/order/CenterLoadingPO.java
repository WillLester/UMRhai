package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;

public class CenterLoadingPO extends PO implements Serializable{
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
	
	public CenterLoadingPO(Calendar date, String id, String target,
			String vanId, String supervision, String escort,
			ArrayList<String> express, Calendar opTime, String opName) {
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
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into centerlorderwaiting values"+"("+"'"+id+"','"+target+"','"+vanId+"','"+supervision+"','"+escort+"','"+DateFormat.DATE.format(date.getTime())+"','"+DateFormat.TIME.format(opTime.getTime())+"','"+opName+"')";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	
}
