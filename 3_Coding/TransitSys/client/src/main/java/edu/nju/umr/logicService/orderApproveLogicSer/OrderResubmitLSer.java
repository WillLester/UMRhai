package edu.nju.umr.logicService.orderApproveLogicSer;

import edu.nju.umr.vo.ResultMessage;

public interface OrderResubmitLSer {
	/**
	 * getUnpassed 获得未通过单据的数量
	 * <p>  获得未通过单据的数量
	 * @param id 需要用户名
	 * @return 返回数量
	 */
	public ResultMessage getUnpassed(String id);
	/**
	 * getOrdersDisplay 获得未通过单据列表
	 * <p> 获得未通过单据的列表，形式是OrderVO，参考单据审批的形式
	 * @param 没有，直接从逻辑层获得
	 * @return 返回OrderVO的列表
	 */
	public ResultMessage getOrdersDisplay();
	/**
	 * getOrder 获得某一个未通过的单据
	 * <p> 获得某一个未通过的单据，形式是某种单据的VO
	 * @param int index，需要知道在列表中的位置
	 * @return 返回相应的VO供显示
	 */
	public ResultMessage getOrder(int index);
}
