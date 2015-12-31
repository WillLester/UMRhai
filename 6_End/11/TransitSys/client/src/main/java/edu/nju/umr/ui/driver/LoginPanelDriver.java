package edu.nju.umr.ui.driver;
import edu.nju.umr.ui.MainFrame;
public class LoginPanelDriver {
	public void drive(){
		@SuppressWarnings("unused")
		MainFrame f = new MainFrame();
	}
	public static void main(String[] args){
		LoginPanelDriver d = new LoginPanelDriver();
		d.drive();
	}
}
