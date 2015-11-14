package edu.nju.umr.logicService.stockLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.StockVO;

public interface StockCheckNowLSer {
	public ResultMessage checkNow(String id);
	public Result outputExcel(String location,StockVO stock);
}
