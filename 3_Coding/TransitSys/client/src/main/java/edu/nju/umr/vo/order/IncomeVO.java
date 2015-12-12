package edu.nju.umr.vo.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.orderNewUI.IncomePanel;

public class IncomeVO implements ShowOrder{
	private Calendar date;
	private String courier;
	private BigDecimal cost;
	private ArrayList<String> express;
	private String opName;
	private String orgId;
	private String userId;
	private String account;
	public IncomeVO(Calendar date,String courier,BigDecimal cost,ArrayList<String> express,String opName,String orgId,String userId
			,String account) {
		// TODO 自动生成的构造函数存根
		this.date = date;
		this.courier = courier;
		this.cost = cost;
		this.express = express;
		this.opName = opName;
		this.orgId = orgId;
		this.userId = userId;
		this.account = account;
	}
	public Calendar getDate() {
		return date;
	}
	public String getCourier() {
		return courier;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public ArrayList<String> getExpress() {
		return express;
	}
	public String getOpName() {
		return opName;
	}
	
	public String getOrgId() {
		return orgId;
	}
	public String getUserId() {
		return userId;
	}
	public String getAccount() {
		return account;
	}
	public void Show(boolean isEnabled){
		FunctionFrame ffr=new FunctionFrame("入款单");
		IncomePanel panel=new IncomePanel(ffr,this);
		panel.setEnabled(isEnabled);
		ffr.setContentPane(panel);
	}
	
}
