package edu.nju.umr.ui.userManUI;

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

public class UserListPanel extends JPanel {
	private JTextField textField;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public UserListPanel() {
		setLayout(null);
		
		JLabel accountLabel = new JLabel("用户管理");
		accountLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		accountLabel.setBounds(504, 6, 129, 60);
		add(accountLabel);
		
		textField = new JTextField();
		textField.setText("请输入关键字");
		textField.setBounds(233, 67, 542, 24);
		add(textField);
		textField.setColumns(10);
		
		
		JButton searchButton = new JButton("搜索");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 12));
		searchButton.setBounds(827, 66, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(searchButton);
		
		table = new JTable();
		table.setBounds(233, 101, 637, 335);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(table);
		
		JButton addButton = new JButton("新增");
		addButton.setFont(new Font("宋体", Font.PLAIN, 12));
		addButton.setBounds(275, 487, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(addButton);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 12));
		deleteButton.setBounds(395, 487, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(deleteButton);
		
		JButton confirmButton = new JButton("修改");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(504, 487, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(confirmButton);
		
		JButton cancelButton = new JButton("查看");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 12));
		cancelButton.setBounds(626, 487, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(cancelButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(795, 487, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(exitButton);

	}
}
