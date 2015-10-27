package edu.nju.umr.ui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;

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
		FuncFrame funcFrame = new FuncFrame("功能");
		desktop.add(funcFrame);
		funcFrame.setVisible(true);
	}
}
