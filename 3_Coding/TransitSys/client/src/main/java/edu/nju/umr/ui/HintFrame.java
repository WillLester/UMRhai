package edu.nju.umr.ui;

import javax.swing.JDialog;

public class HintFrame extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5725804299757185729L;
	static final int FRAME_WIDTH = (int)(1366*0.3);
	static final int FRAME_HEIGHT = (int)(768*0.3);
	/**
	 * Create the frame.
	 */
	public HintFrame(String title,int x,int y) {
		setTitle(title);
		setBounds(x * 2, y * 2, FRAME_WIDTH, FRAME_HEIGHT);

	}
}
