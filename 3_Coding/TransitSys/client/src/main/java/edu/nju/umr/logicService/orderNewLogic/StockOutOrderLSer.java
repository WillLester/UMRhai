package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockOutVO;

public interface StockOutOrderLSer {
	public Result create(StockOutVO order);
	public ResultMessage getCities();
	/**
	 * 检测订单是否存在
	 * @param id 订单号
	 * @return 结果
	 */
	public boolean isExpressValid(String id);
}
