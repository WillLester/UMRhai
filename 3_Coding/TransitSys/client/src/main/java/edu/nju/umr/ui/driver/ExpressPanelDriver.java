package edu.nju.umr.ui.driver;
import javax.swing.JFrame;

import edu.nju.umr.ui.orderNewUI.ExpressPanel;
public class ExpressPanelDriver {
	public void drive(){
		JFrame frame=new JFrame();
		frame.setSize(1200,800);
		ExpressPanel p = new ExpressPanel(frame, "1", "2");
		frame.add(p);
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		ExpressPanelDriver ed=new ExpressPanelDriver();
		ed.drive();
	}
}
