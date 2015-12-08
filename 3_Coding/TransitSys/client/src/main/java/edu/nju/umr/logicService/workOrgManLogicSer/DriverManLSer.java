package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.DriverVO;
import edu.nju.umr.vo.ResultMessage;
/**
 * 司机管理的逻辑层接口
 * @author Lester
 *
 */
public interface DriverManLSer {
	/**
	 * 增加司机
	 * @param Driver DriverVO
	 * @param name 操作者姓名
	 * @return 结果
	 */
	public Result addDriver(DriverVO Driver,String name);
	/**
	 * 删除司机
	 * @param id 司机编号
	 * @param name 操作者姓名
	 * @return 结果
	 */
	public Result deleteDriver(String id,String name);
	/**
	 * 修改司机
	 * @param Driver DriverVO
	 * @param name 操作者姓名
	 * @see DriverVO
	 * @return 结果
	 */
	public Result reviseDriver(DriverVO Driver,String name);
	/**
	 * 搜索司机
	 * @param hallId 营业厅编号
	 * @return 司机VO的List
	 * @see DriverVO
	 */
	public ResultMessage searchDriver(String hallId);//司机没有关键词搜索，所以只有机构
}