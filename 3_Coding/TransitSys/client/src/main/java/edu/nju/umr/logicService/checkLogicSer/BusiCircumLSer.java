package edu.nju.umr.logicService.checkLogicSer;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public interface BusiCircumLSer {
	public ResultMessage seeBusinessCircum(Date start,Date end);
	public ResultMessage getHall();
	public Result outputExcel(ArrayList<IncomeVO> income,String location);
}
