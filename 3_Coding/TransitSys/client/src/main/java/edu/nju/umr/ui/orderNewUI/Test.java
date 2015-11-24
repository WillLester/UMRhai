package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.ui.DatePanel;

public class Test extends JPanel {
	private JTextField payerField;
	private JTextField costField;
	private JFrame frame;
	private DatePanel datePanel;
	/**
	 * Create the panel.
	 */
	public Test(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		JLabel titleLabel = new JLabel("付款单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392, 10, 243, 67);
		add(titleLabel);
		
		JLabel dateLabel = new JLabel("付款日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(286, 98, 120, 24);
		add(dateLabel);
		
//		JSpinner spinner = new JSpinner();
//		spinner.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(0), null, new Integer(1)));
//		spinner.setFont(new Font("宋体", Font.PLAIN, 20));
//		spinner.setBounds(392, 97, 85, 26);
//		add(spinner);
		
//		JLabel label = new JLabel("年");
//		label.setFont(new Font("宋体", Font.PLAIN, 20));
//		label.setBounds(487, 99, 25, 22);
//		add(label);
//		
//		JSpinner spinner_1 = new JSpinner();
//		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
//		spinner_1.setFont(new Font("宋体", Font.PLAIN, 20));
//		spinner_1.setBounds(522, 97, 48, 26);
//		add(spinner_1);
//		
//		JLabel label_1 = new JLabel("月");
//		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
//		label_1.setBounds(580, 99, 25, 22);
//		add(label_1);
//		
//		JSpinner spinner_2 = new JSpinner();
//		spinner_2.setModel(new SpinnerNumberModel(1, 1, 31, 1));
//		spinner_2.setFont(new Font("宋体", Font.PLAIN, 20));
//		spinner_2.setBounds(615, 97, 48, 26);
//		add(spinner_2);
//		
//		JLabel label_2 = new JLabel("日");
//		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
//		label_2.setBounds(673, 99, 25, 22);
//		add(label_2);
		
		JLabel payerLabel = new JLabel("付款人");
		payerLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		payerLabel.setBounds(235, 175, 85, 24);
		add(payerLabel);
		
		payerField = new JTextField();
		payerField.setFont(new Font("宋体", Font.PLAIN, 20));
		payerField.setColumns(10);
		payerField.setBounds(302, 174, 85, 25);
		add(payerField);
		
		JLabel costLabel = new JLabel("付款金额");
		costLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		costLabel.setBounds(397, 175, 85, 24);
		add(costLabel);
		
		costField = new JTextField();
		costField.setFont(new Font("宋体", Font.PLAIN, 20));
		costField.setColumns(10);
		costField.setBounds(487, 174, 85, 25);
		add(costField);
		
		JLabel remarkLabel = new JLabel("备注");
		remarkLabel.setHorizontalAlignment(SwingConstants.CENTER);
		remarkLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		remarkLabel.setBounds(429, 291, 130, 24);
		add(remarkLabel);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(342, 499, 93, 23);
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(542, 499, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancelButton);
		
		JLabel accountLabel = new JLabel("付款账号");
		accountLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		accountLabel.setBounds(597, 175, 85, 24);
		add(accountLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(274, 325, 435, 154);
		add(textArea);
		
		JLabel label_6 = new JLabel("条目");
		label_6.setFont(new Font("宋体", Font.PLAIN, 20));
		label_6.setBounds(437, 237, 59, 24);
		add(label_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox.setBounds(499, 237, 87, 25);
		add(comboBox);
		
		datePanel=new DatePanel();
		datePanel.setBounds(474, 98, 285, 26);
		add(datePanel);
		
		JComboBox accountCombo = new JComboBox();
		accountCombo.setBounds(692, 175, 111, 21);
		add(accountCombo);

	}
}
