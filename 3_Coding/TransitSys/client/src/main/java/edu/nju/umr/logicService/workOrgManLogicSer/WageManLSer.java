package edu.nju.umr.logicService.workOrgManLogicSer;

import java.util.List;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WageVO;

public interface WageManLSer {
	public ResultMessage searchWorks(String keyword);
	public Result setWage(List<WageVO> wageList);
	
}
