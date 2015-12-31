package edu.nju.umr.logic.driver;
import edu.nju.umr.logic.userLogic.LoginLogic;
import edu.nju.umr.vo.ResultMessage;
public class LoginLogicDriver {
	public void drive() throws Exception{
		LoginLogic l =new LoginLogic();
		ResultMessage m=l.login("1", "2");
		System.out.println(m.getMessage());
	}
	public static void main(String[] args) throws Exception{
		LoginLogicDriver d=new LoginLogicDriver();
		d.drive();
	}

}
