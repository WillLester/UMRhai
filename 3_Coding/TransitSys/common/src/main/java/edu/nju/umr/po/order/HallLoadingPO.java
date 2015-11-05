package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class HallLoadingPO implements Serializable{
	private String id;
	private String hallId;
	private String convertId;
	private String arriveLoc;
	private String vanId;
	private String supervision;
	private String escort;
	private ArrayList<String> express;
	private Calendar date;
	private Calendar opTime;
	
	public HallLoadingPO(String id, String hallId, String convertId,
			String arriveLoc, String vanId, String supervision, String escort,
			ArrayList<String> express, Calendar date, Calendar opTime) {
		super();
		this.id = id;
		this.hallId = hallId;
		this.convertId = convertId;
		this.arriveLoc = arriveLoc;
		this.vanId = vanId;
		this.supervision = supervision;
		this.escort = escort;
		this.express = express;
		this.date = date;
		this.opTime = opTime;
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
	public String getId() {
		return id;
	}
	
}
