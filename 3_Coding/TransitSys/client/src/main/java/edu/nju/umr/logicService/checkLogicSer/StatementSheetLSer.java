package edu.nju.umr.logicService.checkLogicSer;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.vo.IncomeVO;
import edu.nju.umr.vo.ResultMessage;

public interface StatementSheetLSer {
	public ResultMessage seeStatementSheet(Date start,Date end,String id);
	public ResultMessage getHall();
	public boolean outputExcel(ArrayList<IncomeVO> income,String location);
}
