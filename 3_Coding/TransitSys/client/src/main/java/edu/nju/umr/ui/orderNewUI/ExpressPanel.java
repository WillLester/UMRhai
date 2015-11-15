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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ExpressPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Create the panel.
	 */
	public ExpressPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("订单创建");
		label.setBounds(437, 21, 120, 35);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		add(label);
		
		JLabel label_1 = new JLabel("订单条形码号");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(341, 66, 120, 24);
		add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(489, 65, 165, 25);
		add(textField);
		
		JLabel label_2 = new JLabel("寄件人");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(84, 101, 120, 24);
		add(label_2);
		
		JLabel label_3 = new JLabel("姓名");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(178, 135, 120, 24);
		add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(268, 134, 83, 25);
		add(textField_1);
		
		JLabel label_4 = new JLabel("住址");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(378, 135, 62, 24);
		add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(437, 135, 165, 25);
		add(textField_2);
		
		JLabel label_5 = new JLabel("单位");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(615, 135, 62, 24);
		add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(676, 134, 165, 25);
		add(textField_3);
		
		JLabel label_6 = new JLabel("手机");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("宋体", Font.PLAIN, 20));
		label_6.setBounds(178, 180, 120, 24);
		add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(268, 179, 193, 25);
		add(textField_4);
		
		JLabel label_7 = new JLabel("电话");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("宋体", Font.PLAIN, 20));
		label_7.setBounds(510, 180, 62, 24);
		add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(567, 179, 216, 25);
		add(textField_5);
		
		JLabel label_8 = new JLabel("收件人");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("宋体", Font.PLAIN, 20));
		label_8.setBounds(84, 214, 120, 24);
		add(label_8);
		
		JLabel label_9 = new JLabel("姓名");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("宋体", Font.PLAIN, 20));
		label_9.setBounds(178, 248, 120, 24);
		add(label_9);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(268, 247, 83, 25);
		add(textField_6);
		
		JLabel label_10 = new JLabel("住址");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("宋体", Font.PLAIN, 20));
		label_10.setBounds(378, 248, 62, 24);
		add(label_10);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(437, 248, 165, 25);
		add(textField_7);
		
		JLabel label_11 = new JLabel("单位");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("宋体", Font.PLAIN, 20));
		label_11.setBounds(615, 248, 62, 24);
		add(label_11);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(676, 248, 165, 25);
		add(textField_8);
		
		JLabel label_12 = new JLabel("手机");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("宋体", Font.PLAIN, 20));
		label_12.setBounds(178, 294, 120, 24);
		add(label_12);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(268, 293, 193, 25);
		add(textField_9);
		
		JLabel label_13 = new JLabel("电话");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("宋体", Font.PLAIN, 20));
		label_13.setBounds(510, 294, 62, 24);
		add(label_13);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_10.setColumns(10);
		textField_10.setBounds(567, 293, 216, 25);
		add(textField_10);
		
		JLabel label_14 = new JLabel("货物信息");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setFont(new Font("宋体", Font.PLAIN, 20));
		label_14.setBounds(84, 328, 120, 24);
		add(label_14);
		
		JLabel label_15 = new JLabel("件数");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("宋体", Font.PLAIN, 20));
		label_15.setBounds(178, 362, 120, 24);
		add(label_15);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner.setBounds(268, 362, 48, 26);
		add(spinner);
		
		JLabel label_16 = new JLabel("体积");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("宋体", Font.PLAIN, 20));
		label_16.setBounds(335, 362, 62, 24);
		add(label_16);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_11.setColumns(10);
		textField_11.setBounds(397, 362, 41, 25);
		add(textField_11);
		
		JLabel lblM = new JLabel("m³");
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setFont(new Font("宋体", Font.PLAIN, 20));
		lblM.setBounds(437, 362, 41, 24);
		add(lblM);
		
		JLabel label_17 = new JLabel("重量");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("宋体", Font.PLAIN, 20));
		label_17.setBounds(479, 362, 62, 24);
		add(label_17);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_12.setColumns(10);
		textField_12.setBounds(531, 361, 41, 25);
		add(textField_12);
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setHorizontalAlignment(SwingConstants.CENTER);
		lblKg.setFont(new Font("宋体", Font.PLAIN, 20));
		lblKg.setBounds(567, 362, 41, 24);
		add(lblKg);
		
		JLabel label_18 = new JLabel("内件品名");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setFont(new Font("宋体", Font.PLAIN, 20));
		label_18.setBounds(597, 362, 120, 24);
		add(label_18);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_13.setColumns(10);
		textField_13.setBounds(704, 361, 193, 25);
		add(textField_13);
		
		JLabel label_19 = new JLabel("包装种类");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setFont(new Font("宋体", Font.PLAIN, 20));
		label_19.setBounds(196, 411, 120, 24);
		add(label_19);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"纸箱", "木箱", "快递袋"}));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox.setBounds(314, 411, 103, 25);
		add(comboBox);
		
		JLabel label_20 = new JLabel("快递种类");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setFont(new Font("宋体", Font.PLAIN, 20));
		label_20.setBounds(437, 411, 120, 24);
		add(label_20);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"经济快递", "标准快递", "特快专递"}));
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox_1.setBounds(554, 411, 123, 25);
		add(comboBox_1);
		
		JLabel label_21 = new JLabel("费用：");
		label_21.setHorizontalAlignment(SwingConstants.LEFT);
		label_21.setFont(new Font("宋体", Font.PLAIN, 20));
		label_21.setBounds(704, 411, 120, 24);
		add(label_21);
		
		JButton button = new JButton("确定");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(341, 484, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(567, 484, 93, 23);
		add(button_1);

	}

}
