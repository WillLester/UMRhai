package edu.nju.umr.ui.driver;

import javax.swing.JFrame;

import edu.nju.umr.ui.LocPanel;

public class LocPanelDriver {
	public void drive(){
		JFrame frame=new JFrame();
		frame.setSize(1200,800);
		LocPanel p=new LocPanel(frame);
		frame.add(p);
		p.setProvince("江苏");
		p.setCityText("哈哈哈");
		frame.setVisible(true);
		
	}
	public static void main(String[] args){
		LocPanelDriver ld=new LocPanelDriver();
		ld.drive();
	}

}
