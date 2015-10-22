package edu.nju.umr.logicService.orderApproveLogicSer;

import java.util.ArrayList;

import edu.nju.umr.vo.ResultMessage;

public interface orderApproveLSer {
	public ResultMessage askExamine();
	public boolean examine(boolean approve,ArrayList<String> id);
	public ResultMessage chooseOrder(String id);
}	
