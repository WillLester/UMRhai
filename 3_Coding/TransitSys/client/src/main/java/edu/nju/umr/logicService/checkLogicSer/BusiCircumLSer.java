package edu.nju.umr.logicService.checkLogicSer;

import java.util.Calendar;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public interface BusiCircumLSer {
//	public ResultMessage seeIncome(Calendar start,Calendar end);
//	public ResultMessage seePayment(Calendar start,Calendar end);
//	public ResultMessage getHall();
	public ResultMessage getBusiCircum(Calendar start,Calendar end);
	public Result outputExcel(String name,String location);
}
