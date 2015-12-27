package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockInVO;

public interface StockInOrderLSer {
	public Result create(StockInVO order);
	public ResultMessage getOrgs();
	public ResultMessage getShelves(String orgId);
	/**
	 * 入库单生成时检测订单是否存在
	 * @param id 订单号
	 * @return 是否存在
	 */
	public boolean isExpressValid(String id);
	public ResultMessage getNextId(String orgId);
	public ResultMessage getComingExpresses(String orgId);
	public Integer[] getRow(String shelf);
	public Integer[] getPlace(String shelf,int row);
}
