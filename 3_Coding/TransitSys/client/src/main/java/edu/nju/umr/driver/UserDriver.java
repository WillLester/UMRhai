package edu.nju.umr.driver;

import java.util.ArrayList;

import edu.nju.umr.logic.userLogic.LoginLogic;
import edu.nju.umr.logic.userLogic.UserManLogic;
import edu.nju.umr.logicService.userLogicSer.LoginLSer;
import edu.nju.umr.logicService.userLogicSer.UserManLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.vo.UserVO;

public class UserDriver {
	LoginLSer login = new LoginLogic();
	UserManLSer user = new UserManLogic();
	public static void main(String[] args) {
		UserDriver driver = new UserDriver();
		driver.driveLogin();
		//driver.driveUser();
	}
	private void driveLogin(){
		UserVO user = (UserVO) login.login("12345", "hhhhh").getMessage();
		//System.out.println(user.getId() + " " + user.getPassword() + " " + user.getOrgId() + " " + user.getJuri() + " " + user.getName() + " " + user.getMobile());
	}
	private void driveUser(){
		UserVO userNew = new UserVO("1","Password",Jurisdiction.ADMIN,"一个用户名啊","一个手机号啊",1,null,null);
		System.out.println(user.newUser(userNew));
		System.out.println(user.deleteUser("00001"));
		System.out.println(user.reviseUser(userNew));
		ArrayList<UserVO> voList = (ArrayList<UserVO>) user.findUser("").getMessage();
		for(UserVO user:voList){
			System.out.println(user.getId() + " " + user.getPassword() + " "  + user.getJuri() + " " + user.getName() + " " + user.getMobile());
		}
	}
}
