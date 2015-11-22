package edu.nju.umr.logicService.checkLogicSer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public interface BusiCircumLSer {
	public ResultMessage seeIncome(Calendar start,Calendar end);
	public ResultMessage seePayment(Calendar start,Calendar end);
	public ResultMessage getHall();
	public Result outputExcel(String data[][],String name,String location);
}
