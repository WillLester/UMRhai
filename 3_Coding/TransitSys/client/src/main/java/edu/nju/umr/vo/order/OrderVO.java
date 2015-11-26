package edu.nju.umr.vo.order;

import java.util.Calendar;

import edu.nju.umr.po.enums.Order;

public class OrderVO {
	private String id;
	private Order kind;
	private String operator;
	private String Org;
	private Calendar time;
	public OrderVO(String id,Order kind,String operator,String Org,Calendar time) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.kind = kind;
		this.operator = operator;
		this.Org=Org;
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public Order getKind() {
		return kind;
	}
	public String getOperator() {
		return operator;
	}
	public Calendar getTime() {
		return time;
	}
}
