package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.RecipientVO;

public interface RecipientOrderLSer {
	public Result create(RecipientVO order);
	public ResultMessage getCities();
}
