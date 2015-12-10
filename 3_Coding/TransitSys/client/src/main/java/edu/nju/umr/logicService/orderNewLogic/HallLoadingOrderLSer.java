package edu.nju.umr.logicService.orderNewLogic;

import java.util.List;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.HallLoadingVO;

public interface HallLoadingOrderLSer {
	public Result create(HallLoadingVO order);
	public boolean isLegal(String id);
	public ResultMessage getLocalHallAndAllCenter(String orgId);
	public ResultMessage getVans(String org);
	public ResultMessage getPrice(String org1,String org2,List<String> expressList);
}
