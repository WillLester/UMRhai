package edu.nju.umr.ui;

import javax.swing.JInternalFrame;

public class FuncFrame extends JInternalFrame {
	static final int FRAME_X = MainFrame.FRAME_WIDTH/10;
	static final int FRAME_Y = MainFrame.FRAME_HEIGHT/10;
	static final int FRAME_WIDTH = (int)(MainFrame.FRAME_WIDTH*0.8);
	static final int FRAME_HEIGHT = (int)(MainFrame.FRAME_HEIGHT*0.8);
	public FuncFrame(String title) {
		setTitle(title);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(FRAME_X,FRAME_Y,FRAME_WIDTH,FRAME_HEIGHT);
	}

}
