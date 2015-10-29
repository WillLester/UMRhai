package edu.nju.umr.ui.accountUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import edu.nju.umr.ui.Constants;

public class AccountManPanel extends JPanel {
	private JTextField textField;
	private JTextField nameField;
	private JTextField balanceField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public AccountManPanel() {
		setLayout(null);
		
		JLabel accountLabel = new JLabel("账户管理");
		accountLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		accountLabel.setBounds(504, 6, 96, 60);
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
		
		nameField = new JTextField();
		nameField.setBounds(360, 468, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel nameLabel = new JLabel("账户名称");
		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		nameLabel.setBounds(283, 465, 67, 30);
		add(nameLabel);
		
		JLabel balanceLabel = new JLabel("账户余额");
		balanceLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		balanceLabel.setBounds(566, 465, 67, 30);
		add(balanceLabel);
		
		balanceField = new JTextField();
		balanceField.setEditable(false);
		balanceField.setBounds(643, 468, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(balanceField);
		balanceField.setColumns(10);
		
		JButton addButton = new JButton("新增");
		addButton.setFont(new Font("宋体", Font.PLAIN, 12));
		addButton.setBounds(326, 525, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(addButton);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 12));
		deleteButton.setBounds(435, 525, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(deleteButton);
		
		JButton confirmButton = new JButton("确认修改");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(546, 525, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消修改");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 12));
		cancelButton.setBounds(656, 525, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(cancelButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(798, 525, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(exitButton);

	}
}
