package edu.nju.umr.ui;

import javax.swing.JFrame;

public class InfoFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4863999246614750264L;
	static final int FRAME_X = FunctionFrame.FRAME_WIDTH/20;
	static final int FRAME_Y = FunctionFrame.FRAME_HEIGHT/40;
	static final int FRAME_WIDTH = (int)(FunctionFrame.FRAME_WIDTH*0.9);
	static final int FRAME_HEIGHT = (int)(FunctionFrame.FRAME_HEIGHT*0.9);
	/**
	 * Create the frame.
	 */
	public InfoFrame(String title) {
		setResizable(false);
		setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		setTitle(title);
		this.setVisible(true);
	}
}
