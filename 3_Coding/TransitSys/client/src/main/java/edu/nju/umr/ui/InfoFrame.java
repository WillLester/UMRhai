package edu.nju.umr.ui;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import edu.nju.umr.ui.accountUI.CountInfoPanel;

public class InfoFrame extends JInternalFrame{
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
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		setTitle(title);
		this.add(new CountInfoPanel());
	}
}
