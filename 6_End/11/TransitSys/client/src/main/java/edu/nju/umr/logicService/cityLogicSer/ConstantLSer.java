package edu.nju.umr.logicService.cityLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ConstantVO;
import edu.nju.umr.vo.ResultMessage;

public interface ConstantLSer {
	/**
	 * 设置常量信息
	 * @param constant 常量VO
	 * @param name 操作者姓名
	 * @see edu.nju.umr.vo.ConstantVO
	 * @return 结果
	 */
	public Result setConstant(ConstantVO constant,String name);
	public ResultMessage getConstant();

}
