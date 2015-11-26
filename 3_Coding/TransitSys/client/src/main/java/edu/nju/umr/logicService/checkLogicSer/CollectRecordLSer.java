package edu.nju.umr.logicService.checkLogicSer;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public interface CollectRecordLSer {
	public ResultMessage seeCollectRecord(Calendar date,String id);
	public ResultMessage total(ArrayList<IncomeVO> income);
}
