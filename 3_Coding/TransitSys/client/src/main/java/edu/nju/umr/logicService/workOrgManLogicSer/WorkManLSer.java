package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.vo.WorkVO;
import edu.nju.umr.vo.ResultMessage;

public interface WorkManLSer {
	public boolean addWork(WorkVO Work);
	public boolean deleteWork(String id);
	public boolean reviseWork(WorkVO Work);
	public ResultMessage checkWork(String id);
	public ResultMessage WorkList();
	public ResultMessage searchWork(String keyword);
}
