package edu.nju.umr.logicService.stockLogicSer;

import edu.nju.umr.po.enums.Part;
import edu.nju.umr.vo.ResultMessage;

public interface StockCheckWarnLSer {
	public ResultMessage checkWarning(String id,Part part);
}
