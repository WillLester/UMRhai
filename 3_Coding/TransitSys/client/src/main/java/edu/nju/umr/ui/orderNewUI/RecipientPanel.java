package edu.nju.umr.ui.orderNewUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipientPanel extends JPanel {
	private JTextField textField;
	private JFrame frame;
	/**
	 * Create the panel.
	 */
	public RecipientPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		JLabel lblNewLabel = new JLabel("营业厅到达单");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(382+40, 45, 242, 67);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("中转单编号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(342+40, 216, 107, 24);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(474+40, 216, 193, 24);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("到达日期");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(342+40, 268, 107, 24);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("出发地");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(342+40, 162, 107, 24);
		add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox.setBounds(474+40, 166, 193, 21);
		add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(0), null, new Integer(1)));
		spinner.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner.setBounds(474+40, 268, 85, 26);
		add(spinner);
		
		JLabel lblNewLabel_5 = new JLabel("年");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(569+40, 269, 25, 22);
		add(lblNewLabel_5);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner_1.setBounds(597+40, 268, 48, 26);
		add(spinner_1);
		
		JLabel lblNewLabel_6 = new JLabel("月");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(655+40, 268, 25, 22);
		add(lblNewLabel_6);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_2.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner_2.setBounds(679+40, 268, 48, 26);
		add(spinner_2);
		
		JLabel lblNewLabel_7 = new JLabel("日");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(737+40, 269, 25, 22);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("货物到达状态");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(329+40, 327, 120, 45);
		add(lblNewLabel_8);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"完整", "损坏", "丢失"}));
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox_1.setBounds(474+40, 338, 193, 24);
		add(comboBox_1);
		
		JButton button = new JButton("确定");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(364+40, 434, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(548+40, 436, 93, 23);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(button_1);

	}
}
