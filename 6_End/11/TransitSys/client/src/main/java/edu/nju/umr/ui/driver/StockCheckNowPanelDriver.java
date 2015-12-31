package edu.nju.umr.ui.driver;
import javax.swing.JFrame;

import edu.nju.umr.ui.stockUI.StockCheckNowPanel;
public class StockCheckNowPanelDriver {
	public void drive(){
		JFrame frame = new JFrame();
		frame.setSize(1200,800);
		StockCheckNowPanel p =new StockCheckNowPanel(frame,"1");
		frame.add(p);
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		StockCheckNowPanelDriver sd=new StockCheckNowPanelDriver();
		sd.drive();
	}

}
