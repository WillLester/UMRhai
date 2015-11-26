package edu.nju.umr.logicService.checkLogicSer;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public interface IncomeListLSer {
	public ResultMessage seeIncomeList(Calendar date,String id);//date为null，表示不限日期；id为null，表示不限营业厅
	public ResultMessage total(ArrayList<IncomeVO> income);
	public ResultMessage getHall();
}
