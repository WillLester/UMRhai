package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
/**
 * 机构管理逻辑接口
 * @author Lester
 *
 */
public interface OrgManLSer {
	/**
	 * 新增机构
	 * @param org OrgVO
	 * @param name 操作者姓名
	 * @see OrgVO
	 * @return 结果
	 */
	public Result addOrg(OrgVO org,String name);
	/**
	 * 删除机构
	 * @param id 机构编号
	 * @param name 操作者姓名
	 * @return 结果
	 */
	public Result deleteOrg(String id,String name);
	/**
	 * 修改机构
	 * @param org OrgVO
	 * @param name 操作者姓名
	 * @see OrgVO
	 * @return 结果
	 */
	public Result reviseOrg(OrgVO org,String name);
	public ResultMessage searchOrg(String keyword);
	public ResultMessage getCities();
}
