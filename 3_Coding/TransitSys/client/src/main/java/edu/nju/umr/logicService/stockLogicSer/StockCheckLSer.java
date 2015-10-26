package edu.nju.umr.logicService.stockLogicSer;

import java.util.Date;

import edu.nju.umr.vo.ResultMessage;

public interface StockCheckLSer {
	public ResultMessage checkStockIn(Date start,Date end,String id);
	public ResultMessage checkStockOut(Date start,Date end,String id);
}