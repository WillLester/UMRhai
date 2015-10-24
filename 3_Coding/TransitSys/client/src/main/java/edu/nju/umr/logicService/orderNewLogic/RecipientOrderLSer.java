package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.RecipientVO;

public interface RecipientOrderLSer {
	public boolean create(RecipientVO order);
	public ResultMessage getCities();
}
