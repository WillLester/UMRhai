package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.transitInfoUI.ExpressInfoInqPanel;

public class Test extends ExpressInfoInqPanel {
	private JTextField textField;
	private DatePanel receiveDate;
	private JLabel timelabel;
	/**
	 * Create the panel.
	 */
	public Test(JFrame fr) {
		super(fr);
		cancelButton.setLocation(642, 564);
		confirmButton.setLocation(418, 564);
		
		textField = new JTextField();
		textField.setBounds(370, 517, 103, 25);
		add(textField);
		textField.setColumns(10);
		
		JLabel receivelabel = new JLabel("收件人");
		receivelabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receivelabel.setBounds(294, 517, 80, 24);
		add(receivelabel);
		
		receiveDate = new DatePanel();
		receiveDate.setBounds(603, 518, 400, 24);
		add(receiveDate);
		
		timelabel = new JLabel("收件时间");
		timelabel.setFont(new Font("宋体", Font.PLAIN, 20));
		timelabel.setBounds(503, 517, 99, 24);
		add(timelabel);
	}
}
