package edu.nju.umr.ui;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import edu.nju.umr.ui.accountUI.CountInfoPanel;

public class InfoFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4863999246614750264L;
	static final int FRAME_X = FunctionFrame.FRAME_WIDTH/20;
	static final int FRAME_Y = FunctionFrame.FRAME_HEIGHT/40;
	static final int FRAME_WIDTH = (int)(FunctionFrame.FRAME_WIDTH*0.9);
	static final int FRAME_HEIGHT = (int)(FunctionFrame.FRAME_HEIGHT*0.9);
	private JDesktopPane desktop;
	/**
	 * Create the frame.
	 */
	public InfoFrame(String title) {
		desktop = new JDesktopPane();
		this.getContentPane().add(desktop);
		setResizable(false);
		setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		setTitle(title);
		System.out.println(this.getWidth() +" " + this.getHeight());
		this.add(new CountInfoPanel());
	}
}
