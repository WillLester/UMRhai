package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.SendVO;

public interface SendOrderLSer {
	public Result create(SendVO order);
	public ResultMessage getCouriers(String id);
	
	/**
	 * 获得派件单编号
	 * @param orgId 机构编号
	 * @return
	 */
	public ResultMessage getNextId(String orgId);
}
