package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockOutVO;

public interface StockOutOrderLSer {
	public Result create(StockOutVO order,String org);
	public ResultMessage getCities();
}
