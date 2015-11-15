package edu.nju.umr.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FunctionFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7900240807053594323L;
	static final int FRAME_X = MainFrame.FRAME_WIDTH/20;
	static final int FRAME_Y = MainFrame.FRAME_HEIGHT/40;
	static final int FRAME_WIDTH = (int)(MainFrame.FRAME_WIDTH*0.9);
	static final int FRAME_HEIGHT = (int)(MainFrame.FRAME_HEIGHT*0.9);
	public FunctionFrame(String title) {
		setTitle(title);
		setResizable(false);
		setBounds(FRAME_X,FRAME_Y,FRAME_WIDTH,FRAME_HEIGHT);
		this.setVisible(true);
		
	}
}
