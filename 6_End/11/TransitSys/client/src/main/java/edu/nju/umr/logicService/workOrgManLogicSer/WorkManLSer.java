package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WorkVO;
/**
 * 人员管理逻辑接口
 * @author Lester
 *
 */
public interface WorkManLSer {
	/**
	 * 添加人员
	 * @param work WorkVO
	 * @param name 操作者姓名
	 * @see WorkVO
	 * @return
	 */
	public Result addWork(WorkVO work,String name);
	/**
	 * 删除人员
	 * @param index 人员在列表中的编号(0-base)
	 * @param name 操作者姓名
	 * @return
	 */
	public Result deleteWork(int index,String name);
	/**
	 * 修改人员
	 * @param work WorkVO
	 * @param index 人员在列表中的编号(0-base)
	 * @param name 操作者姓名
	 * @see WorkVO
	 * @return
	 */
	public Result reviseWork(WorkVO work,int index,String name);
	public ResultMessage searchWork(String keyword);
	public ResultMessage orgList();
}
