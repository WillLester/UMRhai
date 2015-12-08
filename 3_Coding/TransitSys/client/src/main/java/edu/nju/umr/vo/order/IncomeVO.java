package edu.nju.umr.vo.order;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.orderNewUI.IncomePanel;

public class IncomeVO implements ShowOrder{
	private Calendar date;
	private String courier;
	private double cost;
	private ArrayList<String> express;
	private String opName;
	private String orgId;
	private String userId;
	public IncomeVO(Calendar date,String courier,double cost,ArrayList<String> express,String opName,String orgId,String userId) {
		// TODO 自动生成的构造函数存根
		this.date = date;
		this.courier = courier;
		this.cost = cost;
		this.express = express;
//		this.id = id;
		this.opName = opName;
		this.orgId = orgId;
		this.userId = userId;
	}
	public Calendar getDate() {
		return date;
	}
	public String getCourier() {
		return courier;
	}
	public double getCost() {
		return cost;
	}
	public ArrayList<String> getExpress() {
		return express;
	}
//	public String getId() {
//		return id;
//	}
	public String getOpName() {
		return opName;
	}
	
	public String getOrgId() {
		return orgId;
	}
	public String getUserId() {
		return userId;
	}
	public void Show(boolean isEnabled){
		FunctionFrame ffr=new FunctionFrame("入款单");
		IncomePanel panel=new IncomePanel(ffr,this);
		panel.setEnabled(isEnabled);
		ffr.setContentPane(panel);
	}
	
}
