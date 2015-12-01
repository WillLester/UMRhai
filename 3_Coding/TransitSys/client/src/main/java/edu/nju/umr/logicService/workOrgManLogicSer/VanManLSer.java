package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.VanVO;

public interface VanManLSer {
	public Result addVan(VanVO van);
	public Result deleteVan(String id);
	public Result reviseVan(VanVO van);
//	public ResultMessage checkVan(String id);
//	public ResultMessage VanList();
	public ResultMessage searchVan(String keyword,String hallId);
	public ResultMessage getNextId(String hallId);//如果某营业厅新增车辆，获取这个新增车辆应该被分配的编号，规则参见规格文档，注意若现有车辆编号为001,003，新增应为002而不是004,返回的编号为String
}
