package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.VanVO;

public interface VanManLSer {
	public Result addVan(VanVO van);
	public Result deleteVan(String id);
	public Result reviseVan(VanVO van);
	public ResultMessage checkVan(String id);
//	public ResultMessage VanList();
	public ResultMessage searchVan(String keyword);
}
