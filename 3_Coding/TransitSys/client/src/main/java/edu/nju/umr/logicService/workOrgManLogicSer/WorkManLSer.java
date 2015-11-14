package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WorkVO;

public interface WorkManLSer {
	public Result addWork(WorkVO work);
	public Result deleteWork(String id);
	public Result reviseWork(WorkVO work);
	public ResultMessage searchWork(String keyword);
	public ResultMessage orgList();
}
