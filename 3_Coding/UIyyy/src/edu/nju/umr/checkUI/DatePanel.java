package edu.nju.umr.checkUI;

import javax.swing.JPanel;

import edu.nju.umr.ui.Constants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
/*
 * 用以年、月、日的添加
 */
public class DatePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DatePanel() {
		this.setSize(267,21);
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 0, 66, 21);
		add(comboBox);
		
		JLabel label = new JLabel("年");
		label.setBounds(69, 3, 19, 15);
		add(label);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(89, 0, 66, 21);
		add(comboBox_1);
		
		JLabel label_1 = new JLabel("月");
		label_1.setBounds(156, 3, 19, 15);
		add(label_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(175, 0, 66, 21);
		add(comboBox_2);
		
		JLabel label_2 = new JLabel("日");
		label_2.setBounds(244, 3, 19, 15);
		add(label_2);
	}

}
