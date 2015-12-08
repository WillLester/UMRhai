package edu.nju.umr.logicService.orderNewLogic;

import java.util.List;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.TransitVO;

public interface TransitOrderLSer {
	public Result create(TransitVO order,String org);
	public ResultMessage getCenters();
	/**
	 * 检查订单列表是否存在
	 * @param expressList 订单列表
	 * @return 若-1，表示正常，否则表示某一位发生错误，只返回发生错误的第一个编号(0-base)
	 */
	public int isExpressValid(List<String> expressList);
	public ResultMessage getPrice(String org1,String org2,int tran,List<String> expressList);
}
