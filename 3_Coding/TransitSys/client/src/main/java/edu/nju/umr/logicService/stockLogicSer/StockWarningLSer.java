package edu.nju.umr.logicService.stockLogicSer;

import java.util.ArrayList;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public interface StockWarningLSer {
	public Result setWarning(ArrayList<Integer> warnings,String id);
	public ResultMessage getWarning(String id);

}
