package edu.nju.umr.logicService.workOrgManLogicSer;

import java.util.ArrayList;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WageVO;

public interface WageManLSer {
	public ResultMessage WorkList();
	public boolean reviseWage(WageVO wage);
	public ResultMessage getWage(String id);
}
