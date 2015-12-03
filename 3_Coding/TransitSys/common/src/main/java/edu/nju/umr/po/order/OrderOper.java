package edu.nju.umr.po.order;

import edu.nju.umr.po.enums.Order;

public interface OrderOper {
	public Order getOrderKind();
	public String getApprove(boolean isPassed);
	public String getDeleteWaiting();
	public String getDeleteUnpassed();
}
