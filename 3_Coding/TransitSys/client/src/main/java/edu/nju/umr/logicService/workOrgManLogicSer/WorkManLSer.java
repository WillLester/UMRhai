package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.vo.WorkVO;
import edu.nju.umr.vo.ResultMessage;

public interface WorkManLSer {
	public boolean addWork(WorkVO work);
	public boolean deleteWork(String id);
	public boolean reviseWork(WorkVO work);
//	public ResultMessage checkWork(String id);
//	public ResultMessage WorkList();
	public ResultMessage searchWork(String keyword);
	public ResultMessage orgList();
}
