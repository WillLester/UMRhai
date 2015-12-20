package edu.nju.umr.ui.driver;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.userUI.UserListPanel;
public class UserListPanelDriver {
	public void drive(){
		FunctionFrame f= new FunctionFrame("");
		f.setContentPane(new UserListPanel(f, "0"));
		f.setVisible(true);
	}
	public static void main(String[] args){
		UserListPanelDriver d=new UserListPanelDriver();
		d.drive();
	}

}
