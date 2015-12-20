package edu.nju.umr.ui.stub;
import java.util.ArrayList;

import edu.nju.umr.logicService.userLogicSer.UserManLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;
public class UserListPanelStub implements UserManLSer{

	@Override
	public Result newUser(UserVO user, String name) {
		// TODO Auto-generated method stub
		return Result.SUCCESS;
	}

	@Override
	public Result deleteUser(String id, String name, int index) {
		// TODO Auto-generated method stub
		return Result.SUCCESS;
	}

	@Override
	public Result reviseUser(UserVO user, int index, String name) {
		// TODO Auto-generated method stub
		return Result.SUCCESS;
	}

	@Override
	public ResultMessage findUser(String keyword) {
		// TODO Auto-generated method stub
		ArrayList<UserVO> user = new ArrayList<UserVO>();
		user.add(new UserVO("1", "1", Jurisdiction.CENTER, "1", "1", "1", "1"));
		return new ResultMessage(Result.SUCCESS,user);
	}

}
