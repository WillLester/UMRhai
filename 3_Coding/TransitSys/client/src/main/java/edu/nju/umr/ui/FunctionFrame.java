package edu.nju.umr.ui;

import java.util.LinkedList;

import javax.swing.JFrame;

public class FunctionFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7900240807053594323L;
	static final int FRAME_X = MainFrame.FRAME_WIDTH/20;
	static final int FRAME_Y = MainFrame.FRAME_HEIGHT/40;
	static final int FRAME_WIDTH = (int)(MainFrame.FRAME_WIDTH*0.9);
	static final int FRAME_HEIGHT = (int)(MainFrame.FRAME_HEIGHT*0.9);
	public LinkedList<JFrame> sonFrames;
	public FunctionFrame(String title) {
		setTitle(title);
		setLayout(null);
		setResizable(false);
		setBounds(FRAME_X,FRAME_Y,FRAME_WIDTH,FRAME_HEIGHT);
		sonFrames=new LinkedList<JFrame>();
		setVisible(true);
	}
	public void dispose(){
		super.dispose();
		for(JFrame fr:sonFrames)
		{
			fr.dispose();
		}
	}
}
