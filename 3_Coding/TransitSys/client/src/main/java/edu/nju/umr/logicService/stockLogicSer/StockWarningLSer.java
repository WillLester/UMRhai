package edu.nju.umr.logicService.stockLogicSer;

import edu.nju.umr.vo.ResultMessage;

public interface StockWarningLSer {
	public boolean setWarning(int w,int part,String id);
	public ResultMessage getWarning(String id);

}
