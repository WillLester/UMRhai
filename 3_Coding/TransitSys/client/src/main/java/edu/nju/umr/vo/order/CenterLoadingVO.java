package edu.nju.umr.vo.order;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.orderNewUI.CenterLoadingPanel;

public class CenterLoadingVO implements ShowOrder{
	private Calendar date;
	private String transitId;
	private String target;
	private String vanId;
	private String supervision;
	private String escort;
	private ArrayList<String> express;
	private double cost;
	private String opName;
	private String userId;
	private boolean arrived;
	private String startPlace;
	private String startOrgId;
	
	public CenterLoadingVO(Calendar date, String transitId, String target,
			String vanId, String supervision, String escort,
			ArrayList<String> express, double cost, String opName, String userId,boolean arrived,String startPlace,String startOrgId) {
		super();
		this.date = date;
		this.transitId = transitId;
		this.target = target;
		this.vanId = vanId;
		this.supervision = supervision;
		this.escort = escort;
		this.express = express;
		this.cost = cost;
		this.opName = opName;
		this.userId = userId;
		this.arrived=arrived;
		this.startPlace=startPlace;
		this.startOrgId=startOrgId;
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
	public String getTransitId() {
		return transitId;
	}
	public String getUserId() {
		return userId;
	}
	public boolean isArrived(){
		return arrived;
	}
	public String getStartPlace(){
		return startPlace;
	}
	public String getStartOrgId(){
		return startOrgId;
	}
	public void Show(boolean isEnabled) {
		FunctionFrame ffr = new FunctionFrame("中转中心装车单");
		CenterLoadingPanel panel=new CenterLoadingPanel(ffr,this);
		panel.setEnabled(isEnabled);
		ffr.setContentPane(panel);
	}
	
}
