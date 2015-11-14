package edu.nju.umr.ui;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import edu.nju.umr.ui.workOrgManUI.WorkListPanel;

public class FunctionFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7900240807053594323L;
	static final int FRAME_X = MainFrame.FRAME_WIDTH/20;
	static final int FRAME_Y = MainFrame.FRAME_HEIGHT/40;
	static final int FRAME_WIDTH = (int)(MainFrame.FRAME_WIDTH*0.9);
	static final int FRAME_HEIGHT = (int)(MainFrame.FRAME_HEIGHT*0.9);
	private JDesktopPane desktop;
	public FunctionFrame(String title) {
		desktop = new JDesktopPane();
		this.getContentPane().add(desktop);
		setTitle(title);
		setResizable(false);
		setBounds(FRAME_X,FRAME_Y,FRAME_WIDTH,FRAME_HEIGHT);
		System.out.println(this.getWidth()+" " + this.getHeight());
		this.setVisible(true);
		this.getContentPane().add(new WorkListPanel());
//		InfoFrame info = new InfoFrame("期初信息");
//		desktop.add(info);
//		info.setVisible(true);
	}
}
