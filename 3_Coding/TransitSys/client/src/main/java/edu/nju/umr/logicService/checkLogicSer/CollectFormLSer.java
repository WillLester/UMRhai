package edu.nju.umr.logicService.checkLogicSer;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public interface CollectFormLSer {
	public ResultMessage seeCollectRecord(Date date,String id);
	public ResultMessage total(ArrayList<IncomeVO> income);
}
