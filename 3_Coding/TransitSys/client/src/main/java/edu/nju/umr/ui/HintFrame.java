package edu.nju.umr.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HintFrame extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5725804299757185729L;
	public static final int FRAME_WIDTH = (int)(1366*0.3);
	public static final int FRAME_HEIGHT = (int)(768*0.3);
	/**
	 * Create the frame.
	 */
	public HintFrame(String message,int x,int y) {
		setTitle("错误!");
		this.setLayout(null);
		setBounds(x, y, FRAME_WIDTH, FRAME_HEIGHT);
		this.setVisible(true);
		JLabel label=new JLabel(message);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, FRAME_HEIGHT/2-50, FRAME_WIDTH, 40);
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		add(label);
		JButton button_1 = new JButton("确定");
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(FRAME_WIDTH/2-40, FRAME_HEIGHT/2+14, 80, 28);
		add(button_1);

	}
}
