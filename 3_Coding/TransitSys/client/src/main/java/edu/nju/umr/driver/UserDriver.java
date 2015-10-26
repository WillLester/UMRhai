package edu.nju.umr.driver;

import edu.nju.umr.logic.userLogic.LoginLogic;
import edu.nju.umr.logic.userLogic.UserManLogic;
import edu.nju.umr.logicService.userLogicSer.LoginLSer;
import edu.nju.umr.logicService.userLogicSer.UserManLSer;
import edu.nju.umr.vo.UserVO;

public class UserDriver {
	LoginLSer login = new LoginLogic();
	UserManLSer user = new UserManLogic();
	public static void main(String[] args) {
		UserDriver driver = new UserDriver();
		driver.driveLogin();
		driver.driveUser();
	}
	private void driveLogin(){
		UserVO user = (UserVO) login.login("12345", "hhhhh").getMessage();
		System.out.println(user.getId() + " " + user.getPassword() + " " + user.getOrgId() + " " + user.getJuri() + " " + user.getName() + " " + user.getMobile());
	}
	private void driveUser(){
		System.out.println();
	}
}
