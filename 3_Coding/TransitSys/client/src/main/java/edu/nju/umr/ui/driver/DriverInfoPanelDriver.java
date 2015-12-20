package edu.nju.umr.ui.driver;

import java.util.Calendar;

import javax.swing.JFrame;

import edu.nju.umr.po.enums.Gender;
import edu.nju.umr.ui.workOrgManUI.DriverInfoPanel;
import edu.nju.umr.vo.DriverVO;

public class DriverInfoPanelDriver {
	public void drive(){
		JFrame frame = new JFrame();
		frame.setSize(1200,800);
		DriverVO d=new DriverVO("1", "2", Calendar.getInstance(), "3", "4", Gender.MAN, Calendar.getInstance(), Calendar.getInstance(), "7");
		DriverInfoPanel p =new DriverInfoPanel(frame, null, d, "2");
		frame.add(p);
		frame.setVisible(true);
	}
	public static void main(String[] args){
		DriverInfoPanelDriver d = new DriverInfoPanelDriver();
		d.drive();
	}
	

}
