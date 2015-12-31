package edu.nju.umr.logicService.stockLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public interface StockCheckNowLSer {
	public ResultMessage checkNow(String id);
	public Result outputExcel(String location,String name);
}
