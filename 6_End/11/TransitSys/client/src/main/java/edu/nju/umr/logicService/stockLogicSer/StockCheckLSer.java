package edu.nju.umr.logicService.stockLogicSer;

import java.util.Calendar;

import edu.nju.umr.vo.ResultMessage;

public interface StockCheckLSer {
	public ResultMessage orderStock(Calendar start,Calendar end,String id);
}