package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.TransitVO;

public interface TransitOrderLSer {
	public Result create(TransitVO order,String org);
	public ResultMessage getCenters();
}
