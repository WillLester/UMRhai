package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ReceiveVO;

public interface ReceiveOrderLSer {
	public boolean create(ReceiveVO order);
	public ResultMessage getExpress(String id);
}
