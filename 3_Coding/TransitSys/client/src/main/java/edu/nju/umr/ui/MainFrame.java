package edu.nju.umr.ui;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	static final int FRAME_X = Toolkit.getDefaultToolkit().getScreenSize().width/10;
	static final int FRAME_Y = Toolkit.getDefaultToolkit().getScreenSize().height/10;
	static final int FRAME_WIDTH = (int)(Toolkit.getDefaultToolkit().getScreenSize().width*0.8);
	static final int FRAME_HEIGHT = (int)(Toolkit.getDefaultToolkit().getScreenSize().height*0.8);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("快递物流系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(FRAME_X,FRAME_Y,FRAME_WIDTH,FRAME_HEIGHT);
		
	}
}
