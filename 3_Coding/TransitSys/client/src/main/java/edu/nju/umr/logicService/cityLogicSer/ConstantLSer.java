package edu.nju.umr.logicService.cityLogicSer;

import edu.nju.umr.vo.ConstantVO;
import edu.nju.umr.vo.ResultMessage;

public interface ConstantLSer {
	public boolean setConstant(ConstantVO constant);
	public ResultMessage getConstant();

}
