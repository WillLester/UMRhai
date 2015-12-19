package edu.nju.umr.ui.driver;

import javax.swing.JFrame;

import edu.nju.umr.ui.orderApproveUI.OrderRevisePanel;

public class OrderRevisePanelDriver {
	public void drive(){
		JFrame frame=new JFrame();
		frame.setSize(1200,800);
		OrderRevisePanel p = new OrderRevisePanel(frame,"1");
		frame.add(p);
		frame.setVisible(true);
		
	}
	public static void main(String[] args)
	{
		OrderRevisePanelDriver od=new OrderRevisePanelDriver();
		od.drive();
	}

}
