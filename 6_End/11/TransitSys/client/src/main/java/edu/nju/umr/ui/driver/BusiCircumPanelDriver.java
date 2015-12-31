package edu.nju.umr.ui.driver;

import javax.swing.JFrame;

import edu.nju.umr.ui.checkUI.BusiCircumPanel;

public class BusiCircumPanelDriver {
	public void drive(){
		JFrame frame=new JFrame();
		frame.setSize(1200,800);
		BusiCircumPanel p=new BusiCircumPanel(frame);
		frame.add(p);
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		BusiCircumPanelDriver bd=new BusiCircumPanelDriver();
		bd.drive();
	}

}
