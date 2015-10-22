package edu.nju.umr.logicService.stockLogicSer;

import java.util.Date;

import edu.nju.umr.vo.ResultMessage;

public interface StockCheckLSer {
	public ResultMessage checkStock(Date start,Date end,String id);
}