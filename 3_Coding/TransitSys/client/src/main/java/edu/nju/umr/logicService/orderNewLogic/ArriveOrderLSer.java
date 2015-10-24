package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ArriveVO;

public interface ArriveOrderLSer {
	public boolean create(ArriveVO order);
	public ResultMessage getCities();
}
