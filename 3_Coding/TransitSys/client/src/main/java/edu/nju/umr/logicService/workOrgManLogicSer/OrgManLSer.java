package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;

public interface OrgManLSer {
	public boolean addOrg(OrgVO org);
	public boolean deleteOrg(String id);
	public boolean reviseOrg(OrgVO org);
//	public ResultMessage checkOrg(String id);
//	public ResultMessage orgList();
	public ResultMessage searchOrg(String keyword);
	public ResultMessage getCities();
}
