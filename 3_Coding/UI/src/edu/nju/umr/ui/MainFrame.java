package edu.nju.umr.ui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	static final int FRAME_X = Toolkit.getDefaultToolkit().getScreenSize().width/10;
	static final int FRAME_Y = Toolkit.getDefaultToolkit().getScreenSize().height/10;
	static final int FRAME_WIDTH = (int)(Toolkit.getDefaultToolkit().getScreenSize().width*0.8);
	static final int FRAME_HEIGHT = (int)(Toolkit.getDefaultToolkit().getScreenSize().height*0.8);
	private JDesktopPane desktop;
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
		desktop = new JDesktopPane();
		this.getContentPane().add(desktop);
		setTitle("快递物流系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(FRAME_X,FRAME_Y,FRAME_WIDTH,FRAME_HEIGHT);
		FunctionFrame func = new FunctionFrame("账户管理");
		desktop.add(func);
		func.setVisible(true);
		try {
			func.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
