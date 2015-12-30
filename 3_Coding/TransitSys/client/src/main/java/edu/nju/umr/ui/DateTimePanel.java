package edu.nju.umr.ui;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;

import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;

public class DateTimePanel extends DatePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8511840723406611830L;
	private UMRComboBox<String> hourCombo;
	private UMRComboBox<String> minuteCombo;
	private UMRComboBox<String> secondCombo;
	public DateTimePanel() {
		// TODO 自动生成的构造函数存根
		super();
		hourCombo = new UMRComboBox<String>();
		hourCombo.setBounds(263, 0, 66, Constants.DATE_HEIGHT);
		String hours[] = new String[24];
		for(int i = 0;i <= 23;i++){
			hours[i] = ""+i;
		}
		hourCombo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		hourCombo.setModel(new DefaultComboBoxModel<String>(hours));
		add(hourCombo);
		
		UMRLabel hourLabel = new UMRLabel("时");
		hourLabel.setMidFont();
		hourLabel.setBounds(332, 3, 19,Constants.DATE_HEIGHT);
		add(hourLabel);
		
		minuteCombo = new UMRComboBox<String>();
		minuteCombo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		minuteCombo.setBounds(351, 0, 66,Constants.DATE_HEIGHT);
		String minutes[] = new String[60];
		for(int i = 0;i <= 59;i++){
			minutes[i] = ""+i;
		}
		minuteCombo.setModel(new DefaultComboBoxModel<String>(minutes));
		add(minuteCombo);
		
		UMRLabel minuteLabel = new UMRLabel("分");
		minuteLabel.setMidFont();
		minuteLabel.setBounds(420, 3, 19,Constants.DATE_HEIGHT);
		add(minuteLabel);
		
		secondCombo = new UMRComboBox<String>();
		secondCombo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		secondCombo.setBounds(439, 0, 66, Constants.DATE_HEIGHT);
		String seconds[] = new String[60];
		for(int i = 0;i <= 59;i++){
			seconds[i] = ""+i;
		}
		secondCombo.setModel(new DefaultComboBoxModel<String>(seconds));
		add(secondCombo);
		
		UMRLabel secondLabel = new UMRLabel("秒");
		secondLabel.setMidFont();
		secondLabel.setBounds(508, 3, 19, Constants.DATE_HEIGHT);
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
