package edu.nju.umr.ui.driver;

import javax.swing.JFrame;

import edu.nju.umr.ui.ExpressListPanel;

public class ExpressListPanelDriver {
	public void drive(){
		JFrame frame=new JFrame();
		frame.setSize(1200, 800);
		ExpressListPanel p = new ExpressListPanel(frame);
		frame.add(p);
		frame.setVisible(true);
	}
	public static void main(String [] args)
	{
		ExpressListPanelDriver ed=new ExpressListPanelDriver();
		ed.drive();
	}
}
