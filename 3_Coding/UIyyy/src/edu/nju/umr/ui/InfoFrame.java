package edu.nju.umr.ui;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class InfoFrame extends JInternalFrame {
	static final int FRAME_X = FunctionFrame.FRAME_WIDTH/20;
	static final int FRAME_Y = FunctionFrame.FRAME_HEIGHT/20;
	static final int FRAME_WIDTH = (int)(FunctionFrame.FRAME_WIDTH*0.9);
	static final int FRAME_HEIGHT = (int)(FunctionFrame.FRAME_HEIGHT*0.9);
	private JDesktopPane desktop;
	/**
	 * Create the frame.
	 */
	public InfoFrame(String title) {
		desktop = new JDesktopPane();
		this.getContentPane().add(desktop);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		setTitle(title);
		HintFrame hint = new HintFrame("提示",FRAME_X,FRAME_Y);
		desktop.add(hint);
		hint.setVisible(true);
	}

}
