package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.HallLoadingVO;

public interface HallLoadingOrderLSer {
	public boolean create(HallLoadingVO order);
	public ResultMessage getOrgs();
	public ResultMessage getVans();
}
