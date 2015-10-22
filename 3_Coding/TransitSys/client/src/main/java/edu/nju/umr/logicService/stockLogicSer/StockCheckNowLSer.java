package edu.nju.umr.logicService.stockLogicSer;

import java.util.Date;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.StockVO;

public interface StockCheckNowLSer {
	public ResultMessage checkNow(String id);
	public boolean setPoint(String id,Date date);
	public boolean outputExcel(String location,StockVO stock);
}
