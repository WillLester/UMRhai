package edu.nju.umr.logicService.orderApproveLogicSer;

import java.util.ArrayList;

import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public interface OrderApproveLSer {
	public ResultMessage askExamine();
	public Result examine(boolean approve,ArrayList<String> id);
	public ResultMessage chooseOrder(String id,Order kind);
}	
