package edu.nju.umr.ui.driver;
import javax.swing.JFrame;

import edu.nju.umr.ui.orderNewUI.TransitPanel;
public class TransitPanelDriver {
	public void drive(){
		JFrame frame = new JFrame();
		frame.setSize(1200,800);
		TransitPanel p =new TransitPanel(frame, "1", "2", "3", "4");
		frame.add(p);
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		TransitPanelDriver td=new TransitPanelDriver();
		td.drive();
	}
}
