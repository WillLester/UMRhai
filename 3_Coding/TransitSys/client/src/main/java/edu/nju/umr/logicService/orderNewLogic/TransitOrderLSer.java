package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.TransitVO;

public interface TransitOrderLSer {
	public boolean create(TransitVO order);
	public ResultMessage getCities();
}
