package edu.nju.umr.logicService.accountLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public interface CountLSer {
	public Result newCount();
//	public ResultMessage checkInitInfo(String id);
	public Result deleteCount(int index);
	public ResultMessage getCount();
}
