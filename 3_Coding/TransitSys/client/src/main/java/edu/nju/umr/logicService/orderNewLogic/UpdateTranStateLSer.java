package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public interface UpdateTranStateLSer {
	public Result updateExpressState(String id,String nowOrgId);
	public ResultMessage getExpressHere(String nowOrgId);
}
