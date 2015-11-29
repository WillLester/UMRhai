package edu.nju.umr.logicService.orderApproveLogicSer;

import edu.nju.umr.vo.ResultMessage;

public interface OrderResubmitLSer {
	public ResultMessage toRevise();
	public ResultMessage getOrders(String id);
}
