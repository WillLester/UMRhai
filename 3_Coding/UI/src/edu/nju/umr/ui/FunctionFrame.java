package edu.nju.umr.ui;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import edu.nju.umr.ui.accountUI.AccountManPanel;

public class FunctionFrame extends JInternalFrame {
	static final int FRAME_X = MainFrame.FRAME_WIDTH/10;
	static final int FRAME_Y = MainFrame.FRAME_HEIGHT/10;
	static final int FRAME_WIDTH = (int)(MainFrame.FRAME_WIDTH*0.8);
	static final int FRAME_HEIGHT = (int)(MainFrame.FRAME_HEIGHT*0.8);
	private JDesktopPane desktop;
	public FunctionFrame(String title) {
		desktop = new JDesktopPane();
		this.getContentPane().add(desktop);
		setTitle(title);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(FRAME_X,FRAME_Y,FRAME_WIDTH,FRAME_HEIGHT);
//		InfoFrame info = new InfoFrame("信息");
//		desktop.add(info);
//		info.setVisible(true);
		this.getContentPane().add(new AccountManPanel());
	}

}
