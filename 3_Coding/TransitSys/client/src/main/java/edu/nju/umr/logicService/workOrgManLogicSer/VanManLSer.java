package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.VanVO;
/**
 * 车辆管理逻辑接口
 * @author Lester
 *
 */
public interface VanManLSer {
	/**
	 * 添加车辆
	 * @param van VanVO
	 * @param name 操作者姓名
	 * @see VanVO
	 * @return 结果
	 */
	public Result addVan(VanVO van,String name);
	/**
	 * 删除车辆
	 * @param id 车辆编号
	 * @param name 操作者姓名
	 * @return 结果
	 */
	public Result deleteVan(String id,String name);
	/**
	 * 修改车辆
	 * @param van VanVO
	 * @param name 操作者姓名
	 * @see VanVO
	 * @return 结果
	 */
	public Result reviseVan(VanVO van,String name);
	public ResultMessage searchVan(String keyword,String hallId);
	public ResultMessage getNextId(String hallId);//如果某营业厅新增车辆，获取这个新增车辆应该被分配的编号，规则参见规格文档，注意若现有车辆编号为001,003，新增应为002而不是004,返回的编号为String
}
