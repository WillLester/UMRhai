package edu.nju.umr.logicService.orderNewLogic;

import java.util.List;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.CenterLoadingVO;


public interface CenterLoadingOrderLSer {
	public Result create(CenterLoadingVO order);
	public ResultMessage getHalls();
	public ResultMessage getPrice(String org1,String org2,List<String> expressList);
	public ResultMessage getNextId(String orgId);
	public ResultMessage getExpressList(String orgId);
}
