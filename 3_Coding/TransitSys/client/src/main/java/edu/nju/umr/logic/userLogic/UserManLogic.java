package edu.nju.umr.logic.userLogic;

import java.util.ArrayList;

import edu.nju.umr.logicService.userLogicSer.UserManLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;

public class UserManLogic implements UserManLSer{

	public boolean newUser(UserVO user) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteUser(String id) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseUser(UserVO user) {
		// TODO 自动生成的方法存根
		return true;
	}

	public ResultMessage checkUser(String id) {
		// TODO 自动生成的方法存根
		UserVO user = new UserVO("1","Password",Jurisdiction.ADMIN,"一个用户名啊","一个手机号啊","一个机构编号啊");
		ResultMessage message = new ResultMessage(true, user);
		return message;
	}

	public ResultMessage userList() {
		// TODO 自动生成的方法存根
		UserVO user1 = new UserVO("1","Password",Jurisdiction.ADMIN,"一个用户名啊","一个手机号啊","一个机构编号啊");
		UserVO user2 = new UserVO("2","Passwor2",Jurisdiction.ADMIN,"一个用户名啊2","一个手机号啊2","一个机构编号啊2");
		ArrayList<UserVO> ar=new ArrayList<UserVO>();
		ar.add(user1);
		ar.add(user2);
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

}
