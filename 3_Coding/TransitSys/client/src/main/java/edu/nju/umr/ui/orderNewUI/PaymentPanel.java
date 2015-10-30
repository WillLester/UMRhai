package edu.nju.umr.ui.orderNewUI;

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

public class PaymentPanel extends JPanel {
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PaymentPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("付款单");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(392, 10, 243, 67);
		add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("付款日期");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(286, 98, 120, 24);
		add(lblNewLabel_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(0), null, new Integer(1)));
		spinner.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner.setBounds(392, 97, 85, 26);
		add(spinner);
		
		JLabel label = new JLabel("年");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(487, 99, 25, 22);
		add(label);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner_1.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner_1.setBounds(522, 97, 48, 26);
		add(spinner_1);
		
		JLabel label_1 = new JLabel("月");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(580, 99, 25, 22);
		add(label_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_2.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner_2.setBounds(615, 97, 48, 26);
		add(spinner_2);
		
		JLabel label_2 = new JLabel("日");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(673, 99, 25, 22);
		add(label_2);
		
		JLabel label_3 = new JLabel("付款人");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(235, 175, 85, 24);
		add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(302, 174, 85, 25);
		add(textField_2);
		
		JLabel label_4 = new JLabel("付款金额");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(397, 175, 85, 24);
		add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(487, 174, 85, 25);
		add(textField_3);
		
		JLabel label_8 = new JLabel("备注");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("宋体", Font.PLAIN, 20));
		label_8.setBounds(429, 291, 130, 24);
		add(label_8);
		
		JButton button = new JButton("确定");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(342, 499, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(542, 499, 93, 23);
		add(button_1);
		
		JLabel label_5 = new JLabel("付款账号");
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(597, 175, 85, 24);
		add(label_5);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(692, 174, 120, 25);
		add(textField);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(274, 325, 435, 154);
		add(textArea);
		
		JLabel label_6 = new JLabel("条目");
		label_6.setFont(new Font("宋体", Font.PLAIN, 20));
		label_6.setBounds(437, 237, 85, 24);
		add(label_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox.setBounds(499, 237, 87, 25);
		add(comboBox);
		

	}
}
