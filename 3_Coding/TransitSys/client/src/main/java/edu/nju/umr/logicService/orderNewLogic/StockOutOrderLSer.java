package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockOutVO;

public interface StockOutOrderLSer {
	public Result create(StockOutVO order);
	public ResultMessage getOrgs();
	/**
	 * 检测订单是否存在
	 * @param id 订单号
	 * @return 结果
	 */
	public boolean isExpressValid(String id);
	/**
	 * 检测中转单是否存在
	 * @param id 中转单编号
	 * @return 结果
	 */
	public boolean isTransitValid(String id);
	/**
	 * 检测装车单是否存在
	 * @param id 汽运编号
	 * @return 结果
	 */
	public boolean isConveyValid(String id);
	public ResultMessage getNextId(String orgId);
	public ResultMessage getGoingOrders(String org,String orgId);
	public ResultMessage getGoingExpress(String orderId,String orgId);
}
