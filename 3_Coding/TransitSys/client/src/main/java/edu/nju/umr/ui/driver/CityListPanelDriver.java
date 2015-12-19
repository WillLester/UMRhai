package edu.nju.umr.ui.driver;
import javax.swing.JFrame;

import edu.nju.umr.ui.cityUI.CityListPanel;

public class CityListPanelDriver {
	public void drive(){
		JFrame frame=new JFrame();
		CityListPanel p=new CityListPanel(frame,"Manageer");
		frame.setSize(1200,800);
		frame.add(p);
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		CityListPanelDriver cd=new CityListPanelDriver();
		cd.drive();
	}

}
