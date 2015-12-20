package edu.nju.umr.logic.driver;
import edu.nju.umr.logic.userLogic.UserManLogic;
public class UserManLogicDriver {
	public void dirve(){
		UserManLogic l =new UserManLogic();
		l.findUser("0");
	}
	public static void main(String[] args){
		UserManLogicDriver d= new UserManLogicDriver();
		d.dirve();
	}

}
