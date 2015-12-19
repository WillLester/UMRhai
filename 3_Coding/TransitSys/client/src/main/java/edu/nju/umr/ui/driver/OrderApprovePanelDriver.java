package edu.nju.umr.ui.driver;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.orderApproveUI.OrderApprovePanel;
public class OrderApprovePanelDriver {
	public void drive(){
		FunctionFrame frame=new FunctionFrame("");
		OrderApprovePanel p=new OrderApprovePanel(frame,"HAHA");
		frame.setContentPane(p);
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		OrderApprovePanelDriver od=new OrderApprovePanelDriver();
		od.drive();
	}

}
