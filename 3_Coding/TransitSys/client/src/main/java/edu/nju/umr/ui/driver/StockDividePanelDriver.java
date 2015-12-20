package edu.nju.umr.ui.driver;
import javax.swing.JFrame;

import edu.nju.umr.ui.stockUI.StockDividePanel;
public class StockDividePanelDriver {
	public void drive(){
		JFrame frame=new JFrame();
		frame.setSize(1200,800);
		StockDividePanel p = new StockDividePanel(frame, "1", "2");
		frame.add(p);
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		StockDividePanelDriver sd=new StockDividePanelDriver();
		sd.drive();
	}
}
