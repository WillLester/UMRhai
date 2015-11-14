package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockInVO;

public interface StockInOrderLSer {
	public Result create(StockInVO order);
	public ResultMessage getCities();
}
