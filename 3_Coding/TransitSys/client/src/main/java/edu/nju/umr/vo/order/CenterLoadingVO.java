package edu.nju.umr.vo.order;

import java.util.ArrayList;
import java.util.Calendar;

public class CenterLoadingVO {
	private Calendar date;
//	private String id;
	private String target;
	private String vanId;
	private String supervision;
	private String escort;
	private ArrayList<String> express;
	private double cost;
	private String opName;
	public CenterLoadingVO(Calendar date,String target,String vanId,String supervision,String escort,ArrayList<String> express,double cost,String opName) {
		// TODO 自动生成的构造函数存根
		this.date = date;
//		this.id = id;
		this.target = target;
		this.vanId = vanId;
		this.supervision = supervision;
		this.escort = escort;
		this.express = express;
		this.cost=cost;
		this.opName=opName;
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
	public double getCost(){
		return cost;
	}
	public String getOpName() {
		return opName;
	}
//	public String getId() {
//		return id;
//	}
	
}
