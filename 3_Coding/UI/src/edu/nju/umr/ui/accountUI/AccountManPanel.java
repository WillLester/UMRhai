package edu.nju.umr.ui.accountUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import edu.nju.umr.ui.Constants;
import javax.swing.JTable;

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
		accountLabel.setBounds(3*Constants.WIDTH_DIV_9, Constants.LABEL_Y/10, 2*Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(accountLabel);
		
		textField = new JTextField();
		textField.setText("请输入关键字");
		textField.setBounds(Constants.WIDTH_DIV_5/2, Constants.HEIGHT_DIV_10, Constants.TEXTFIELD_WIDTH_L, Constants.TEXTFIELD_HEIGHT);
		add(textField);
		textField.setColumns(10);
		
		
		JButton searchButton = new JButton("搜索");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 12));
		searchButton.setBounds(10*Constants.WIDTH_DIV_15*19/20, Constants.HEIGHT_DIV_10, Constants.BUTTON_WIDTH_S, Constants.BUTTON_HEIGHT);
		add(searchButton);
		
		nameField = new JTextField();
		nameField.setBounds(Constants.WIDTH_DIV_15*3, Constants.HEIGHT_DIV_10*5, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel nameLabel = new JLabel("账户名称");
		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		nameLabel.setBounds(Constants.WIDTH_DIV_15*2, Constants.HEIGHT_DIV_10*5, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(nameLabel);
		
		JLabel balanceLabel = new JLabel("账户余额");
		balanceLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		balanceLabel.setBounds(Constants.WIDTH_DIV_15*6, Constants.HEIGHT_DIV_10*5, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(balanceLabel);
		
		balanceField = new JTextField();
		balanceField.setEditable(false);
		balanceField.setBounds(Constants.WIDTH_DIV_15*7, Constants.HEIGHT_DIV_10*5, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(balanceField);
		balanceField.setColumns(10);
		
		JButton addButton = new JButton("新增");
		addButton.setFont(new Font("宋体", Font.PLAIN, 12));
		addButton.setBounds(Constants.WIDTH_DIV_15*3, Constants.HEIGHT_DIV_10*6, Constants.BUTTON_WIDTH_S, Constants.BUTTON_HEIGHT);
		add(addButton);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 12));
		deleteButton.setBounds(Constants.WIDTH_DIV_15*4, Constants.HEIGHT_DIV_10*6, Constants.BUTTON_WIDTH_S, Constants.BUTTON_HEIGHT);
		add(deleteButton);
		
		JButton confirmButton = new JButton("确认修改");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(Constants.WIDTH_DIV_15*5, Constants.HEIGHT_DIV_10*6, Constants.BUTTON_WIDTH_S*3/2, Constants.BUTTON_HEIGHT);
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消修改");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 12));
		cancelButton.setBounds(Constants.WIDTH_DIV_15*6*17/16, Constants.HEIGHT_DIV_10*6, Constants.BUTTON_WIDTH_S*3/2, Constants.BUTTON_HEIGHT);
		add(cancelButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(Constants.WIDTH_DIV_15*8, Constants.HEIGHT_DIV_10*6, Constants.BUTTON_WIDTH_S, Constants.BUTTON_HEIGHT);
		add(exitButton);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(188, 122, 450, 168);
		add(table);

	}
}
