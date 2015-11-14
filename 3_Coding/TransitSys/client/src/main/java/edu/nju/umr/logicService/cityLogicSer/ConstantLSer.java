package edu.nju.umr.logicService.cityLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ConstantVO;
import edu.nju.umr.vo.ResultMessage;

public interface ConstantLSer {
	public Result setConstant(ConstantVO constant);
	public ResultMessage getConstant();

}
