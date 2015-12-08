package edu.nju.umr.ui;

import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class DateTimePanel extends DatePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8511840723406611830L;
	private JComboBox<String> hourCombo;
	private JComboBox<String> minuteCombo;
	private JComboBox<String> secondCombo;
	public DateTimePanel() {
		// TODO 自动生成的构造函数存根
		super();
		hourCombo = new JComboBox<String>();
		hourCombo.setBounds(263, 0, 66, 21);
		String hours[] = new String[24];
		for(int i = 0;i <= 23;i++){
			hours[i] = ""+i;
		}
		hourCombo.setModel(new DefaultComboBoxModel<String>(hours));
		add(hourCombo);
		
		JLabel hourLabel = new JLabel("时");
		hourLabel.setBounds(332, 3, 19, 15);
		add(hourLabel);
		
		minuteCombo = new JComboBox<String>();
		minuteCombo.setBounds(351, 0, 66, 21);
		String minutes[] = new String[60];
		for(int i = 0;i <= 59;i++){
			minutes[i] = ""+i;
		}
		minuteCombo.setModel(new DefaultComboBoxModel<String>(minutes));
		add(minuteCombo);
		
		JLabel minuteLabel = new JLabel("分");
		minuteLabel.setBounds(420, 3, 19, 15);
		add(minuteLabel);
		
		secondCombo = new JComboBox<String>();
		secondCombo.setBounds(439, 0, 66, 21);
		String seconds[] = new String[60];
		for(int i = 0;i <= 59;i++){
			seconds[i] = ""+i;
		}
		secondCombo.setModel(new DefaultComboBoxModel<String>(seconds));
		add(secondCombo);
		
		JLabel secondLabel = new JLabel("秒");
		secondLabel.setBounds(508, 3, 19, 15);
		add(secondLabel);
	}
	public Calendar getCalendar(){
		Calendar calendar = super.getCalendar();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), hourCombo.getSelectedIndex(), minuteCombo.getSelectedIndex(), secondCombo.getSelectedIndex());
		return calendar;
	}
	public void setEnabled(boolean enabled){
		super.setEnabled(enabled);
		hourCombo.setEnabled(enabled);
		minuteCombo.setEnabled(enabled);
		secondCombo.setEnabled(enabled);
	}
}
