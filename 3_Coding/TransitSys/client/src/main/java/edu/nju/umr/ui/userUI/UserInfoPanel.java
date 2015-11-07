package edu.nju.umr.ui.userUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import edu.nju.umr.ui.Constants;

public class UserInfoPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the panel.
	 */
	public UserInfoPanel() {
		setLayout(null);
		
		JLabel accountLabel = new JLabel("用户信息管理");
		accountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accountLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		accountLabel.setBounds(396, 10, 273, 60);
		add(accountLabel);
		
		JLabel label = new JLabel("账号");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(406, 77, 40, 24);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(460, 80, 193, 24);
		add(textField);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(406, 127, 40, 24);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(460, 130, 193, 24);
		add(textField_1);
		
		JLabel label_2 = new JLabel("权限等级");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(368, 186, 95, 24);
		add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(460, 190, 156, 21);
		add(comboBox);
		
		JLabel label_3 = new JLabel("姓名");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(406, 243, 40, 24);
		add(label_3);
		
		JLabel label_4 = new JLabel("手机号");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(385, 296, 78, 24);
		add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(460, 243, 193, 24);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(460, 296, 193, 24);
		add(textField_3);
		
		JButton button = new JButton("确定");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(384, 380, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("关闭");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(547, 382, 93, 23);
		add(button_1);

	}
}
