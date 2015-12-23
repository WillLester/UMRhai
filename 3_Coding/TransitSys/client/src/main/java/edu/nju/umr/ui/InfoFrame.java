package edu.nju.umr.ui;

import edu.nju.umr.ui.component.EFrame;

public class InfoFrame extends EFrame{
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
		super( FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setLocation(FRAME_X, FRAME_Y);
		setTitle(title);
		this.setVisible(true);
	}
}
