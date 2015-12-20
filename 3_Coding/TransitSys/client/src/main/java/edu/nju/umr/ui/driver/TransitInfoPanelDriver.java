package edu.nju.umr.ui.driver;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.transitInfoUI.TransitInfoInqPanel;
public class TransitInfoPanelDriver {
	public static void main(String[] args){
		TransitInfoPanelDriver td = new TransitInfoPanelDriver();
		td.drive();
	}
	public void drive(){
		MainFrame frame= new MainFrame();
		frame.setSize(1200,800);
		TransitInfoInqPanel p =new TransitInfoInqPanel(frame);
		frame.setContentPane(p);
		frame.setVisible(true);
		
	}

}
