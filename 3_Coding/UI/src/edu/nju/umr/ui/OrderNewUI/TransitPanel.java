package edu.nju.umr.ui.OrderNewUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class TransitPanel extends JPanel {
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public TransitPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("中转单");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(392, 10, 243, 67);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("中转单编号");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(355, 87, 120, 24);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setBounds(485, 87, 165, 25);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("装车日期");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(297, 121, 120, 24);
		add(lblNewLabel_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(0), null, new Integer(1)));
		spinner.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner.setBounds(411, 121, 85, 26);
		add(spinner);
		
		JLabel label = new JLabel("年");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(506, 122, 25, 22);
		add(label);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner_1.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner_1.setBounds(541, 122, 48, 26);
		add(spinner_1);
		
		JLabel label_1 = new JLabel("月");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(599, 122, 25, 22);
		add(label_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_2.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner_2.setBounds(634, 122, 48, 26);
		add(spinner_2);
		
		JLabel label_2 = new JLabel("日");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(692, 122, 25, 22);
		add(label_2);
		
		JLabel lblNewLabel_4 = new JLabel("出发地");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(242, 155, 85, 24);
		add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox.setBounds(307, 155, 87, 25);
		add(comboBox);
		
		JLabel label_4 = new JLabel("监装员");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(609, 157, 85, 24);
		add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(674, 158, 85, 25);
		add(textField_3);
		
		JLabel label_5 = new JLabel("航班号");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(220, 204, 120, 24);
		add(label_5);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(328, 203, 165, 25);
		add(textField);
		
		JLabel label_6 = new JLabel("运费：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 20));
		label_6.setBounds(696, 204, 232, 24);
		add(label_6);
		
		JLabel label_7 = new JLabel("订单条形码号");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("宋体", Font.PLAIN, 20));
		label_7.setBounds(220, 255, 130, 24);
		add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(355, 254, 280, 25);
		add(textField_4);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(656, 256, 93, 23);
		add(btnNewButton);
		
		JLabel label_8 = new JLabel("已输入订单");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("宋体", Font.PLAIN, 20));
		label_8.setBounds(401, 289, 130, 24);
		add(label_8);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(220, 313, 529, 176);
		//this.add(new JScrollPane(table));
		add(table);
		
		JButton button = new JButton("确定");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(342, 499, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(542, 499, 93, 23);
		add(button_1);
		
		JLabel label_3 = new JLabel("到达地");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(421, 155, 85, 24);
		add(label_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox_1.setBounds(485, 157, 87, 25);
		add(comboBox_1);
		
		JLabel label_9 = new JLabel("货柜号");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("宋体", Font.PLAIN, 20));
		label_9.setBounds(506, 204, 120, 24);
		add(label_9);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(609, 203, 69, 25);
		add(textField_2);
		

	}
}
