package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ArriveVO;

public interface ArriveOrderLSer {
	public Result create(ArriveVO order);
	public ResultMessage getCities();
}
