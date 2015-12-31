package edu.nju.umr.logicService.orderApproveLogicSer;

import edu.nju.umr.po.enums.Order;
import edu.nju.umr.vo.ResultMessage;

public interface OrderChooseLSer {
	public ResultMessage chooseOrder(String id,Order kind);
}
