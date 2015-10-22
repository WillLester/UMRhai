package edu.nju.umr.logicService.userLogicSer;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;

public interface UserManLSer {
	public boolean newUser(UserVO user);
	public boolean deleteUser(String id);
	public boolean reviseUser(UserVO user);
	public ResultMessage checkUser(String id);
	public ResultMessage userList();
}
