package edu.nju.umr.ui.checkUI;

import javax.swing.JPanel;

import edu.nju.umr.ui.Constants;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.util.Calendar;
/*
 * 用以年、月、日的添加
 */
public class DatePanel extends JPanel {

	JComboBox comboBox;
	JComboBox comboBox_1;
	JComboBox comboBox_2;
	/**
	 * Create the panel.
	 */
	public DatePanel() {
		this.setSize(267,21);
		setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(0, 0, 66, 21);
		int nowyear=Calendar.getInstance().get(Calendar.YEAR);
		String [] years={Integer.toString(nowyear-1),Integer.toString(nowyear),Integer.toString(nowyear+1)};
		comboBox.setModel(new DefaultComboBoxModel(years));
		add(comboBox);
		
		JLabel label = new JLabel("年");
		label.setBounds(69, 3, 19, 15);
		add(label);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(89, 0, 66, 21);
		String [] months={"1","2","3","4","5","6","7","8","9","10","11","12"};
		comboBox_1.setModel(new DefaultComboBoxModel(months));
		add(comboBox_1);
		
		JLabel label_1 = new JLabel("月");
		label_1.setBounds(156, 3, 19, 15);
		add(label_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(175, 0, 66, 21);
		add(comboBox_2);
		
		JLabel label_2 = new JLabel("日");
		label_2.setBounds(244, 3, 19, 15);
		add(label_2);
	}
	public Calendar getCalendar(){
		//Calendar calender=Calendar.getInstance();
		
	}
	

}
