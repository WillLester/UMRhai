package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WageVO;

public interface WageManLSer {
	public ResultMessage searchWorker(String keyword);
	public boolean reviseWage(WageVO wage);
//	public ResultMessage getWage(String id);
}
