package edu.nju.umr.ui.driver;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.workOrgManUI.WorkWageListPanel;

public class WorkWageListPanelDriver {
	public void drive(){
		FunctionFrame f=new FunctionFrame("");
		f.setContentPane(new WorkWageListPanel(f, "0"));
		f.setVisible(true);
	}
	public static void main(String[] args){
		WorkWageListPanelDriver d= new WorkWageListPanelDriver();
		d.drive();
	}

}
