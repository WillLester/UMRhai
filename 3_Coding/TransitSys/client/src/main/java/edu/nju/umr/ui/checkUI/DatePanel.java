package edu.nju.umr.ui.checkUI;

import javax.swing.JPanel;

import edu.nju.umr.ui.Constants;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
		comboBox.setSelectedIndex(1);
		add(comboBox);
		
		JLabel label = new JLabel("年");
		label.setBounds(69, 3, 19, 15);
		add(label);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(89, 0, 66, 21);
		String [] months={"1","2","3","4","5","6","7","8","9","10","11","12"};
		comboBox_1.setModel(new DefaultComboBoxModel(months));
		comboBox_1.setSelectedIndex(Calendar.getInstance().get(Calendar.MONTH));
		add(comboBox_1);
		
		JLabel label_1 = new JLabel("月");
		label_1.setBounds(156, 3, 19, 15);
		add(label_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(175, 0, 66, 21);
		setDate((String)comboBox.getModel().getSelectedItem(),(String)comboBox_1.getModel().getSelectedItem());
		comboBox_2.setSelectedIndex(Calendar.getInstance().get(Calendar.DATE)-1);
		add(comboBox_2);
		
		JLabel label_2 = new JLabel("日");
		label_2.setBounds(244, 3, 19, 15);
		add(label_2);
		
		comboBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1)
				setDate((String)comboBox.getModel().getSelectedItem(),(String)comboBox_1.getModel().getSelectedItem());
			}
		});
		
		comboBox_1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1)
				setDate((String)comboBox.getModel().getSelectedItem(),(String)comboBox_1.getModel().getSelectedItem());
			}
		});
	}
	public Calendar getCalendar(){
		Calendar calendar=Calendar.getInstance();
		calendar.set(Integer.parseInt((String)comboBox.getModel().getSelectedItem()), Integer.parseInt((String)comboBox_1.getModel().getSelectedItem()),Integer.parseInt((String)comboBox_2.getModel().getSelectedItem()));
		return calendar;
		
	}
	private void setDate(String year,String month){
		String[][] dates={{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"},
				{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"},
				{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"},
				{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"}};
		int date=-1;
		int y=Integer.parseInt(year);
		int m=Integer.parseInt(month);
		switch(m){
		case 1:;
		case 3:;
		case 5:;
		case 7:;
		case 8:;
		case 10:;
		case 12:date=0;break;
		case 4:;
		case 6:;
		case 9:;
		case 11:date=1;break;
		case 2:if(y%400==0||(y%4==0&&y%100!=0))date=2;else date=3;break;
		}
		comboBox_2.setModel(new DefaultComboBoxModel(dates[date]));
	}
}
