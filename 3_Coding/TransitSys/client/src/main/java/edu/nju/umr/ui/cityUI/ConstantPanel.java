package edu.nju.umr.ui.cityUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;


public class ConstantPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JFrame frame;
	/**
	 * Create the panel.
	 */
	public ConstantPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		JLabel lblNewLabel = new JLabel("常量制定");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(367, 10, 242, 82);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("飞机满载量(吨)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(246, 94, 90, 15);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("火车满载量(吨)");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(246, 144, 90, 15);
		add(label);
		
		JLabel label_1 = new JLabel("汽车满载量(吨)");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(246, 191, 90, 15);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(362, 91, 43, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(362, 141, 43, 21);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(362, 188, 43, 21);
		add(textField_2);
		
		JLabel label_2 = new JLabel("飞机运费(元每公里每吨)");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		label_2.setBounds(466, 94, 143, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("火车运费(元每公里每吨)");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("宋体", Font.PLAIN, 12));
		label_3.setBounds(466, 144, 143, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("汽车运费(元每公里每吨)");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("宋体", Font.PLAIN, 12));
		label_4.setBounds(466, 188, 143, 15);
		add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(637, 91, 43, 21);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(637, 141, 43, 21);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(637, 188, 43, 21);
		add(textField_5);
		
		JLabel label_5 = new JLabel("快递价格比");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("宋体", Font.PLAIN, 12));
		label_5.setBounds(246, 266, 90, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("经济快递");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("宋体", Font.PLAIN, 12));
		label_6.setBounds(346, 266, 67, 15);
		add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(410, 263, 43, 21);
		add(textField_6);
		
		JLabel label_7 = new JLabel(":");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("宋体", Font.PLAIN, 12));
		label_7.setBounds(451, 266, 13, 15);
		add(label_7);
		
		JLabel label_8 = new JLabel("标准快递");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("宋体", Font.PLAIN, 12));
		label_8.setBounds(458, 266, 67, 15);
		add(label_8);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(519, 263, 43, 21);
		add(textField_7);
		
		JLabel label_9 = new JLabel(":");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("宋体", Font.PLAIN, 12));
		label_9.setBounds(563, 266, 13, 15);
		add(label_9);
		
		JLabel label_10 = new JLabel("次晨特快");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("宋体", Font.PLAIN, 12));
		label_10.setBounds(572, 266, 67, 15);
		add(label_10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(637, 263, 43, 21);
		add(textField_8);
		
		JButton button = new JButton("确定");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(312, 425, 93, 23);
		add(button);
		
		JButton exitButton = new JButton("取消");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 20));
		exitButton.setBounds(519, 427, 93, 23);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(exitButton);

	}
}