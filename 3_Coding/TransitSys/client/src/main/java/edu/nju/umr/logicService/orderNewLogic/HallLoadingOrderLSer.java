package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.HallLoadingVO;

public interface HallLoadingOrderLSer {
	public Result create(HallLoadingVO order);
	public ResultMessage getOrgs();
	public ResultMessage getVans();
}
