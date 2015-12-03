package edu.nju.umr.vo.order;

import java.util.ArrayList;
import java.util.Calendar;

public class HallLoadingVO {
	private String hallId;
	private String convertId;
	private String arriveLoc;
	private String vanId;
	private String supervision;
	private String escort;
	private ArrayList<String> express;
	private double cost;
	private Calendar date;
	private String opName;
	private String userId;
	public HallLoadingVO(String hallId,String convertId,String arriveLoc,String vanId,String supervision, String escort,ArrayList<String> express,double cost,Calendar date,String opName,String userId) {
		// TODO 自动生成的构造函数存根
		this.hallId = hallId;
		this.convertId = convertId;
		this.arriveLoc = arriveLoc;
		this.vanId = vanId;
		this.supervision = supervision;
		this.escort = escort;
		this.express = express;
		this.cost=cost;
		this.date=date;
		this.opName=opName;
		this.userId = userId;
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
	public double getCost(){
		return cost;
	}
	public String getOpName() {
		return opName;
	}
	public Calendar getDate() {
		return date;
	}
	public String getUserId() {
		return userId;
	}
	
}
