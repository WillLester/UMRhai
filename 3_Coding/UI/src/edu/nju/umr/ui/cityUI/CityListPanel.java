package edu.nju.umr.ui.cityUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CityListPanel extends JPanel {
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public CityListPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("城市管理");
		lblNewLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		lblNewLabel.setBounds(508, 35, 88, 29);
		add(lblNewLabel);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(140, 80, 403, 367);
		add(table);
		
		table_1 = new JTable();
		table_1.setBounds(567, 80, 403, 367);
		add(table_1);
		
		JLabel label = new JLabel("城市名");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(313, 471, 54, 23);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(377, 472, 106, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("区号");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(493, 473, 54, 19);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(531, 471, 106, 23);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("所属省份");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(647, 473, 74, 19);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(716, 472, 106, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("价格");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(400, 520, 43, 29);
		add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(437, 524, 106, 22);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("距离");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		label_4.setBounds(567, 525, 54, 19);
		add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(606, 523, 106, 23);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("新增城市");
		button.setBounds(334, 566, 93, 23);
		add(button);
		
		JButton btnNewButton = new JButton("删除城市");
		btnNewButton.setBounds(450, 566, 93, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("确认修改");
		btnNewButton_1.setBounds(567, 566, 93, 23);
		add(btnNewButton_1);
		
		JButton button_1 = new JButton("取消修改");
		button_1.setBounds(683, 566, 93, 23);
		add(button_1);
		
		JButton button_2 = new JButton("退出");
		button_2.setBounds(871, 566, 93, 23);
		add(button_2);

	}
}
