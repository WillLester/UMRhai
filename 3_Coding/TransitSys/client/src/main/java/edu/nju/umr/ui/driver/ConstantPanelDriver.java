package edu.nju.umr.ui.driver;
import javax.swing.JFrame;

import edu.nju.umr.ui.cityUI.ConstantPanel;
public class ConstantPanelDriver {
	public void drive(){
		JFrame frame=new JFrame();
		frame.setSize(1200,800);
		ConstantPanel p=new ConstantPanel(frame,"HAA");
		frame.add(p);
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		ConstantPanelDriver cd=new ConstantPanelDriver();
		cd.drive();
	}

}
