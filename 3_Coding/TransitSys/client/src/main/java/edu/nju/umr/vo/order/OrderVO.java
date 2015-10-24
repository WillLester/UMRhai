package edu.nju.umr.vo.order;

import java.util.Date;

import edu.nju.umr.po.enums.Order;

public class OrderVO {
	private String id;
	private Order kind;
	private String operator;
	private Date time;
	public OrderVO(String id,Order kind,String operator,Date time) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.kind = kind;
		this.operator = operator;
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Order getKind() {
		return kind;
	}
	public void setKind(Order kind) {
		this.kind = kind;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
