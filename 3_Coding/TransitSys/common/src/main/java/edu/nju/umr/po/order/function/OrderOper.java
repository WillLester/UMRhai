package edu.nju.umr.po.order.function;



public interface OrderOper extends KindGetter {
	public String getApprove(boolean isPassed);
	public String getDeleteWaiting();
	public String getDetail();
	public String getUnpassed();
	public String getDeleteUnpassed();
}
