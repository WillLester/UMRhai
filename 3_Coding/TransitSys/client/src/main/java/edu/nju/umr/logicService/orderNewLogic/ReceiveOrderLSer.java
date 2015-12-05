package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ReceiveVO;

public interface ReceiveOrderLSer {
	public Result create(ReceiveVO receive,String org);
	public ResultMessage getExpress(String id);
}
