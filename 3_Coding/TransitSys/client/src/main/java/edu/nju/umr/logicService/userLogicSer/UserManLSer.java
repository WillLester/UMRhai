package edu.nju.umr.logicService.userLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;

public interface UserManLSer {
	public Result newUser(UserVO user);
	public Result deleteUser(String id);
	public Result reviseUser(UserVO user);
	public ResultMessage findUser(String keyword);
}
