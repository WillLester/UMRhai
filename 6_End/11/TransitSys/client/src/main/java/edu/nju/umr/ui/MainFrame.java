package edu.nju.umr.ui;

import java.util.LinkedList;

import javax.swing.JFrame;

import edu.nju.umr.ui.component.EFrame;
import edu.nju.umr.ui.userUI.LoginPanel;

public class MainFrame extends EFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4661313913087117797L;
	static final int FRAME_X = 1366/20;
	static final int FRAME_Y = 768/40;
	static final int FRAME_WIDTH = (int)(1366*0.9);
	static final int FRAME_HEIGHT = (int)(768*0.9);
	public LinkedList<JFrame> sonFrames;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		super(FRAME_WIDTH, FRAME_HEIGHT);
		this.setResizable(false);
		setTitle("快递物流系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(FRAME_X,FRAME_Y,FRAME_WIDTH,FRAME_HEIGHT);
		this.setVisible(true);
		sonFrames=new LinkedList<JFrame>();
		this.setContentPane(new LoginPanel(this));
	}
	public void dispose(){
		super.dispose();
		for(JFrame fr:sonFrames)
		{
			fr.dispose();
		}
		System.exit(0);
	}
}
