package edu.nju.umr.logicService.userLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;
/**
 * 用户管理的逻辑层接口
 * @author Lester
 *
 */
public interface UserManLSer {
	/**
	 * 增加用户
	 * @param user UserVO
	 * @param name 操作者姓名
	 * @see edu.nju.umr.vo.UserVO
	 * @return 结果
	 */
	public Result newUser(UserVO user,String name);
	/**
	 * 删除用户
	 * @param id 用户的账号
	 * @param name 操作者姓名
	 * @return 结果
	 */
	public Result deleteUser(String id,String name);
	/**
	 * 修改用户
	 * @param user UserVO
	 * @param index 在列表中所处的编号(0-base)
	 * @param name 操作者姓名
	 * @see edu.nju.umr.vo.UserVO
	 * @return 结果
	 */
	public Result reviseUser(UserVO user,int index,String name);
	public ResultMessage findUser(String keyword);
}
