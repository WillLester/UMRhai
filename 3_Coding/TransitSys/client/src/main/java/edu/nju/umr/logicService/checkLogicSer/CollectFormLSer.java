package edu.nju.umr.logicService.checkLogicSer;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.vo.IncomeVO;
import edu.nju.umr.vo.ResultMessage;

public interface CollectFormLSer {
	public ResultMessage seeCollectRecord(Date date,String id);
	public ResultMessage total(ArrayList<IncomeVO> income);
}
