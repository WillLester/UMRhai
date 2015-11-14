package edu.nju.umr.logicService.stockLogicSer;

import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public interface StockWarningLSer {
	public Result setWarning(int w,Part part,String id);
	public ResultMessage getWarning(String id);

}
