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
		textField.setBounds(133, 67, 542, 24);
		add(textField);
		textField.setColumns(10);
		
		
		JButton searchButton = new JButton("搜索");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 12));
		searchButton.setBounds(677, 66, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(searchButton);
		
		table = new JTable();
		table.setBounds(133, 121, 637, 335);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(table);
		
		JButton addButton = new JButton("新增");
		addButton.setFont(new Font("宋体", Font.PLAIN, 12));
		addButton.setBounds(283, 487, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(addButton);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 12));
		deleteButton.setBounds(525, 487, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(deleteButton);
		
		JButton confirmButton = new JButton("确认修改");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(895, 437, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(confirmButton);
//		
//		JButton cancelButton = new JButton("查看");
//		cancelButton.setFont(new Font("宋体", Font.PLAIN, 12));
//		cancelButton.setBounds(626, 487, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
//		add(cancelButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(895, 487, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(exitButton);
		
		JLabel idLabel=new JLabel("账号");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		idLabel.setBounds(805,121, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(idLabel);
		
		JLabel passwordLabel=new JLabel("密码");
		passwordLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		passwordLabel.setBounds(805,171, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(passwordLabel);
		
		JLabel juriLabel=new JLabel("权限");
		juriLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		juriLabel.setBounds(805,221, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(juriLabel);
		
		JLabel nameLabel=new JLabel("姓名");
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		nameLabel.setBounds(805,271, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(nameLabel);
		
		JLabel orgLabel=new JLabel("机构");
		orgLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		orgLabel.setBounds(805,321, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(orgLabel);
		
		JLabel phoneLabel=new JLabel("手机号");
		phoneLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		phoneLabel.setBounds(805,371, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(phoneLabel);
		
		JTextField idField=new JTextField("账号");
		idField.setFont(new Font("宋体", Font.PLAIN, 12));
		idField.setBounds(855,121,200,24);
		add(idField);
		
		JTextField passwordField=new JTextField("密码");
		passwordField.setFont(new Font("宋体", Font.PLAIN, 12));
		passwordField.setBounds(855,171,200,24);
		add(passwordField);
		
//		JTextField juriField=new JTextField("权限");
//		juriField.setFont(new Font("宋体", Font.PLAIN, 12));
//		juriField.setBounds(855,221,200,24);
//		add(juriField);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"总经理", "高级财务人员", "普通财务人员","快递员","营业厅业务员","中转中心业务员","中转中心仓库管理人员"}));
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 12));
		comboBox_1.setBounds(855, 221, 200, 24);
		add(comboBox_1);
		
		JTextField nameField=new JTextField("姓名");
		nameField.setFont(new Font("宋体", Font.PLAIN, 12));
		nameField.setBounds(855,271,200,24);
		add(nameField);
		
//		JTextField orgField=new JTextField("机构");
//		orgField.setFont(new Font("宋体", Font.PLAIN, 12));
//		orgField.setBounds(855,321,200,24);
//		add(orgField);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBox_2.setFont(new Font("宋体", Font.PLAIN, 12));
		comboBox_2.setBounds(855, 321, 200, 24);
		add(comboBox_2);
		
		JTextField phoneField=new JTextField("手机号");
		phoneField.setFont(new Font("宋体", Font.PLAIN, 12));
		phoneField.setBounds(855,371,200,24);
		add(phoneField);

	}
}
