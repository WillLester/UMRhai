package edu.nju.umr.driver;

import edu.nju.umr.logic.userLogic.LoginLogic;
import edu.nju.umr.logic.userLogic.UserManLogic;
import edu.nju.umr.logicService.userLogicSer.LoginLSer;
import edu.nju.umr.logicService.userLogicSer.UserManLSer;

public class UserDriver {
	LoginLSer login = new LoginLogic();
	UserManLSer user = new UserManLogic();
}
