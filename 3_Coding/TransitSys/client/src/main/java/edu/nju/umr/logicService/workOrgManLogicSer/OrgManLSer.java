package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;

public interface OrgManLSer {
	public Result addOrg(OrgVO org);
	public Result deleteOrg(String id);
	public Result reviseOrg(OrgVO org);
//	public ResultMessage checkOrg(String id);
//	public ResultMessage orgList();
	public ResultMessage searchOrg(String keyword);
	public ResultMessage getCities();
}
