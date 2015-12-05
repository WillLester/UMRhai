package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.HallLoadingVO;

public interface HallLoadingOrderLSer {
	public Result create(HallLoadingVO order,String org);
	public ResultMessage getLocalHallAndAllCenter(String orgId);
	public ResultMessage getVans(String org);
	public ResultMessage getPrice(String org1,String org2);
}
