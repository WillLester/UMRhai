package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.CenterLoadingVO;


public interface CenterLoadingOrderLSer {
	public Result create(CenterLoadingVO order);
	public ResultMessage getHalls();
}
