package edu.nju.umr.logic.userLogic;

import edu.nju.umr.logicService.userLogicSer.LoginLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.vo.UserVO;
import edu.nju.umr.vo.ResultMessage;

public class LoginLogic implements LoginLSer{

	public ResultMessage login(String id, String password) {
		// TODO 自动生成的方法存根
		UserVO user = new UserVO("1","Password",Jurisdiction.ADMIN,"一个用户名啊","一个手机号啊","一个机构编号啊");
		ResultMessage message = new ResultMessage(true, user);
		return message;
	}

}
