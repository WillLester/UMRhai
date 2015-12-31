package edu.nju.umr.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;
/*
 * 用以年、月、日的添加
 */
public class DatePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 93870983191916410L;
	private UMRComboBox<String> yearCombo;
	private UMRComboBox<String> monthCombo;
	private UMRComboBox<String> dayCombo;
	
	/**
	 * Create the panel.
	 */
	public DatePanel() {
//		this.setSize(267,21);
		setLayout(null);
		
		yearCombo = new UMRComboBox<String>();
		yearCombo.setBounds(0, 0, 66, Constants.DATE_HEIGHT);
		yearCombo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		int nowyear=Calendar.getInstance().get(Calendar.YEAR);
		String [] years=new String[201];
		for(int i=-100;i<101;i++){
			years[i+100]=Integer.toString(nowyear-i);
		}
		yearCombo.setModel(new DefaultComboBoxModel<String>(years));
		yearCombo.setSelectedIndex(1);
		add(yearCombo);
		
		UMRLabel yearLabel = new UMRLabel("年");
		yearLabel.setMidFont();
		yearLabel.setBounds(69, 1, 19, Constants.DATE_HEIGHT);
		add(yearLabel);
		
		monthCombo = new UMRComboBox<String>();
		monthCombo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		monthCombo.setBounds(89, 0, 66, Constants.DATE_HEIGHT);
		String [] months={"1","2","3","4","5","6","7","8","9","10","11","12"};
		monthCombo.setModel(new DefaultComboBoxModel<String>(months));
		monthCombo.setSelectedIndex(Calendar.getInstance().get(Calendar.MONTH));
		add(monthCombo);
		
		UMRLabel monthLabel = new UMRLabel("月");
		monthLabel.setMidFont();
		monthLabel.setBounds(156, 1, 19, Constants.DATE_HEIGHT);
		add(monthLabel);
		
		dayCombo = new UMRComboBox<String>();
		dayCombo.setBounds(175, 0, 66, Constants.DATE_HEIGHT);
		dayCombo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		setDate((String)yearCombo.getModel().getSelectedItem(),(String)monthCombo.getModel().getSelectedItem());
		dayCombo.setSelectedIndex(Calendar.getInstance().get(Calendar.DATE)-1);
		add(dayCombo);
		
		UMRLabel dayLabel = new UMRLabel("日");
		dayLabel.setMidFont();
		dayLabel.setBounds(244, 1, 19, Constants.DATE_HEIGHT);
		add(dayLabel);
		
		yearCombo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1)
				setDate((String)yearCombo.getModel().getSelectedItem(),(String)monthCombo.getModel().getSelectedItem());
			}
		});
		
		monthCombo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1)
				setDate((String)yearCombo.getModel().getSelectedItem(),(String)monthCombo.getModel().getSelectedItem());
			}
		});
		yearCombo.setSelectedIndex(100);
		monthCombo.setSelectedIndex(Calendar.getInstance().get(Calendar.MONTH));
		dayCombo.setSelectedIndex(Calendar.getInstance().get(Calendar.DATE)-1);
		setBackground(Color.WHITE);
	}
	public Calendar getCalendar(){
		Calendar calendar=Calendar.getInstance();
		calendar.set(Integer.parseInt((String)yearCombo.getModel().getSelectedItem()), Integer.parseInt((String)monthCombo.getModel().getSelectedItem())-1,Integer.parseInt((String)dayCombo.getModel().getSelectedItem()));
		return calendar;
		
	}
	protected void setDate(String year,String month){
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
		dayCombo.setModel(new DefaultComboBoxModel<String>(dates[date]));
	}
	public void setDate(Calendar calendar){
		yearCombo.setSelectedIndex(Calendar.getInstance().get(Calendar.YEAR)-calendar.get(Calendar.YEAR)+100);
		monthCombo.setSelectedIndex(calendar.get(Calendar.MONTH));
		dayCombo.setSelectedIndex(calendar.get(Calendar.DATE)-1);
	}
	public void setEnabled(boolean bool){
		yearCombo.setEnabled(bool);
		monthCombo.setEnabled(bool);
		dayCombo.setEnabled(bool);
	}
	public boolean isEnabled(){
		return yearCombo.isEnabled();
	}
}
