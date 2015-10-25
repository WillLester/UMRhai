package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Date;

import edu.nju.umr.po.enums.Order;

public class OrderPO implements Serializable{
	private String id;
	private Order kind;
	private String operator;
	private Date time;
	private boolean isPassed;
	public OrderPO(String id,Order kind,String operator,Date time,boolean isPassed) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.kind = kind;
		this.operator = operator;
		this.time = time;
		this.isPassed = isPassed;
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
	public Date getTime() {
		return time;
	}
	public boolean isPassed() {
		return isPassed;
	}
}
