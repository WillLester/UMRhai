package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.order.ExpressVO;

public interface ExpressOrderLSer {
	public Result create(ExpressVO order);
}
