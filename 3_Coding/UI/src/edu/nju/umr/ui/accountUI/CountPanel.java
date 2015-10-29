package edu.nju.umr.ui.accountUI;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import edu.nju.umr.ui.Constants;

import java.awt.Font;
import javax.swing.JComboBox;

public class CountPanel extends JPanel {
	private JTextField textField;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public CountPanel() {
		setLayout(null);
		
		JLabel accountLabel = new JLabel("期初建账");
		accountLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		accountLabel.setBounds(6*Constants.WIDTH_DIV_15, Constants.HEIGHT_DIV_10/10, 2*Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(accountLabel);
		
		textField = new JTextField();
		textField.setText("请输入关键字");
		textField.setBounds(Constants.WIDTH_DIV_9*13/10, Constants.HEIGHT_DIV_10*11/10, Constants.TEXTFIELD_WIDTH_L, Constants.TEXTFIELD_HEIGHT);
		add(textField);
		textField.setColumns(10);
		
		
		JButton searchButton = new JButton("搜索");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 12));
		searchButton.setBounds(Constants.WIDTH_DIV_9*13/10+600, Constants.HEIGHT_DIV_10*11/10, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(searchButton);
		
		table = new JTable();
		table.setBounds(157, 97, 627, 334);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(table);
		
		JLabel label = new JLabel("新增账");
		label.setFont(new Font("华文新魏", Font.PLAIN, 17));
		label.setBounds(927, 78, 60, 24);
		add(label);
		
		JLabel label_1 = new JLabel("选择机构");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(831, 108, 69, 24);
		add(label_1);
		
		JLabel label_2 = new JLabel("选择库存");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(831, 153, 69, 24);
		add(label_2);
		
		JLabel label_3 = new JLabel("选择账户");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(831, 201, 69, 24);
		add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(910, 110, 161, 21);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(910, 155, 161, 21);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(910, 203, 161, 21);
		add(comboBox_2);
		
		JButton button = new JButton("确认新增");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(910, 255, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("删除");
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		button_1.setBounds(340, 441, 93, 23);
		add(button_1);
		
		JButton button_2 = new JButton("查看");
		button_2.setFont(new Font("宋体", Font.PLAIN, 12));
		button_2.setBounds(492, 441, 93, 23);
		add(button_2);
		
		JButton button_3 = new JButton("退出");
		button_3.setFont(new Font("宋体", Font.PLAIN, 12));
		button_3.setBounds(899, 553, 93, 23);
		add(button_3);

	}
}
