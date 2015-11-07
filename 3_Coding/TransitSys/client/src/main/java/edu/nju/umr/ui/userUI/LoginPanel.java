package edu.nju.umr.ui.userUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class LoginPanel extends JPanel {
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("快递物流系统");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(414, 10, 242, 67);
		add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("账号");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(414, 104, 40, 24);
		add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(475, 107, 193, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("登陆");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(414, 295, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("关闭");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(575, 295, 93, 23);
		add(button_1);
		
		JLabel label = new JLabel("密码");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(414, 162, 40, 24);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(475, 162, 193, 24);
		add(textField);
		
		JButton button_2 = new JButton("物流信息查询");
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		button_2.setBounds(443, 233, 199, 24);
		add(button_2);

	}
}
