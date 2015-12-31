package edu.nju.umr.logicService.workOrgManLogicSer;

import java.util.List;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WageVO;
/**
 * 薪水管理逻辑接口
 * @author Lester
 *
 */
public interface WageManLSer {
	public ResultMessage searchWorks(String keyword);
	/**
	 * 设置薪水
	 * @param wageList WageVO的列表
	 * @param index 被设置薪水人员的index数组（0-base）
	 * @param name 操作者姓名
	 * @return 结果
	 */
	public Result setWage(List<WageVO> wageList,int[] index,String name);
	
}
