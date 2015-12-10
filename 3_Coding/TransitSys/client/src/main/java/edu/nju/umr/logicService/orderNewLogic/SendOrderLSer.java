package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.SendVO;

public interface SendOrderLSer {
	public Result create(SendVO order);
	public ResultMessage getCouriers(String id);
}
