package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WorkVO;

public interface WorkManLSer {
	public Result addWork(WorkVO work);
	public Result deleteWork(int index);
	public Result reviseWork(WorkVO work,int index);
	public ResultMessage searchWork(String keyword);
	public ResultMessage orgList();
}
