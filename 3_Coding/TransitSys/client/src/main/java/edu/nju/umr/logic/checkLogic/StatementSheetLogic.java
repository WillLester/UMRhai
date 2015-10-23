package edu.nju.umr.logic.checkLogic;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.logicService.checkLogicSer.StatementSheetLSer;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public class StatementSheetLogic implements StatementSheetLSer{

	public ResultMessage seeStatementSheet(Date start, Date end, String id) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage getHall() {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean outputExcel(ArrayList<IncomeVO> income, String location) {
		// TODO 自动生成的方法存根
		return false;
	}

}
