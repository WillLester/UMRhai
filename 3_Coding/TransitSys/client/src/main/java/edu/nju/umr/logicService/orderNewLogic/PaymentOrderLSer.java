package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.order.PaymentVO;

public interface PaymentOrderLSer {
	public Result create(PaymentVO order);
}
