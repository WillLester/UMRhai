package edu.nju.umr.ui.orderNewUI;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class SendPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public SendPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("派件单");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(382, 45, 242, 67);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("托运单条形码号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(342, 216, 140, 24);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(487, 216, 193, 24);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("到达日期");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(342, 268, 107, 24);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("派送员");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(342, 162, 107, 24);
		add(lblNewLabel_4);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(0), null, new Integer(1)));
		spinner.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner.setBounds(487, 267, 85, 26);
		add(spinner);
		
		JLabel lblNewLabel_5 = new JLabel("年");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(575, 269, 25, 22);
		add(lblNewLabel_5);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner_1.setBounds(597, 268, 48, 26);
		add(spinner_1);
		
		JLabel lblNewLabel_6 = new JLabel("月");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(655, 268, 25, 22);
		add(lblNewLabel_6);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_2.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner_2.setBounds(679, 268, 48, 26);
		add(spinner_2);
		
		JLabel lblNewLabel_7 = new JLabel("日");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(737, 269, 25, 22);
		add(lblNewLabel_7);
		
		JButton button = new JButton("确定");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(364, 434, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(548, 436, 93, 23);
		add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(487, 162, 193, 24);
		add(textField_1);

	}
}
