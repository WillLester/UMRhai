package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public interface IncomeOrderLSer {
	public boolean create(IncomeVO order);
	public ResultMessage getCouriers(String id);
}
