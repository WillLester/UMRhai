package edu.nju.umr.po.order;


public interface OrderOper extends KindGetter {
	public String getApprove(boolean isPassed);
	public String getDeleteWaiting();
	public String getDetail();
	public String getDeleteUnpassed();
}
