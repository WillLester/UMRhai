package edu.nju.umr.ui.orderNewUI;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
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

public class StockOutPanel extends JPanel {
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public StockOutPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("出库单");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(392, 10, 243, 67);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("快递编号");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(355, 87, 120, 24);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setBounds(485, 87, 165, 25);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("出库日期");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(297, 134, 120, 24);
		add(lblNewLabel_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(0), null, new Integer(1)));
		spinner.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner.setBounds(411, 133, 85, 26);
		add(spinner);
		
		JLabel label = new JLabel("年");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(506, 135, 25, 22);
		add(label);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner_1.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner_1.setBounds(541, 133, 48, 26);
		add(spinner_1);
		
		JLabel label_1 = new JLabel("月");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(599, 135, 25, 22);
		add(label_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_2.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner_2.setBounds(634, 133, 48, 26);
		add(spinner_2);
		
		JLabel label_2 = new JLabel("日");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(693, 135, 25, 22);
		add(label_2);
		
		JLabel lblNewLabel_4 = new JLabel("目的地");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(355, 179, 85, 24);
		add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox.setBounds(431, 179, 87, 25);
		add(comboBox);
		
		JButton button = new JButton("确定");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(347, 434, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(541, 434, 93, 23);
		add(button_1);
		
		JLabel label_7 = new JLabel("装运形式");
		label_7.setFont(new Font("宋体", Font.PLAIN, 20));
		label_7.setBounds(541, 179, 85, 24);
		add(label_7);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox_1.setBounds(634, 179, 87, 25);
		add(comboBox_1);
		
		JLabel label_3 = new JLabel("中转单/汽运编号");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(315, 282, 160, 24);
		add(label_3);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(485, 281, 233, 25);
		add(textField);
		

	}
}
