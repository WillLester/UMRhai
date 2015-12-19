package edu.nju.umr.logicService.checkLogicSer;

import java.util.Calendar;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.BusiCircumVO;
import edu.nju.umr.vo.ResultMessage;

public interface BusiCircumLSer {
	/**
	 * 获得入款单和付款单的显示形式
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return BusiCircumVO的列表
	 * @see BusiCircumVO
	 */
	public ResultMessage getBusiCircum(Calendar start,Calendar end);
	public Result outputExcel(String name,String location);
}
