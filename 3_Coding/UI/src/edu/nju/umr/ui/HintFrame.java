package edu.nju.umr.ui;

import java.awt.Toolkit;

import javax.swing.JInternalFrame;

public class HintFrame extends JInternalFrame {
	static final int FRAME_WIDTH = (int)(Toolkit.getDefaultToolkit().getScreenSize().width*0.3);
	static final int FRAME_HEIGHT = (int)(Toolkit.getDefaultToolkit().getScreenSize().height*0.3);
	/**
	 * Create the frame.
	 */
	public HintFrame(String title,int x,int y) {
		setClosable(true);
		setIconifiable(true);
		setTitle(title);
		setBounds(x * 2, y * 2, FRAME_WIDTH, FRAME_HEIGHT);

	}

}
