package edu.nju.umr.ui;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import edu.nju.umr.ui.userUI.LoginPanel;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4661313913087117797L;
	static final int FRAME_X = 1366/20;
	static final int FRAME_Y = 768/40;
	static final int FRAME_WIDTH = (int)(1366*0.9);
	static final int FRAME_HEIGHT = (int)(768*0.9);
	private JDesktopPane desktop;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("快递物流系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(FRAME_X,FRAME_Y,FRAME_WIDTH,FRAME_HEIGHT);
		this.setVisible(true);
		this.setContentPane(new LoginPanel(this));
		System.out.println(this.getWidth() + " " + this.getHeight());
	}
}
