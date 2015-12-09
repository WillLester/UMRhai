package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ReceiveVO;

public interface ReceiveOrderLSer {
	/**
	 * 订单收件
	 * @param receive ReceiveVO
	 * @param org 收件机构名
	 * @param name 操作者
	 * @see ReceiveVO
	 * @return
	 */
	public Result create(ReceiveVO receive,String org,String name);
	public ResultMessage getExpress(String id);
}
