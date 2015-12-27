package edu.nju.umr.ui;

import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;

import edu.nju.umr.ui.component.ELabel;
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
		hourCombo.setBounds(263, 0, 66, 21);
		String hours[] = new String[24];
		for(int i = 0;i <= 23;i++){
			hours[i] = ""+i;
		}
		hourCombo.setModel(new DefaultComboBoxModel<String>(hours));
		add(hourCombo);
		
		ELabel hourLabel = new ELabel("时");
		hourLabel.setBounds(332, 3, 19, 15);
		add(hourLabel);
		
		minuteCombo = new UMRComboBox<String>();
		minuteCombo.setBounds(351, 0, 66, 21);
		String minutes[] = new String[60];
		for(int i = 0;i <= 59;i++){
			minutes[i] = ""+i;
		}
		minuteCombo.setModel(new DefaultComboBoxModel<String>(minutes));
		add(minuteCombo);
		
		ELabel minuteLabel = new ELabel("分");
		minuteLabel.setBounds(420, 3, 19, 15);
		add(minuteLabel);
		
		secondCombo = new UMRComboBox<String>();
		secondCombo.setBounds(439, 0, 66, 21);
		String seconds[] = new String[60];
		for(int i = 0;i <= 59;i++){
			seconds[i] = ""+i;
		}
		secondCombo.setModel(new DefaultComboBoxModel<String>(seconds));
		add(secondCombo);
		
		ELabel secondLabel = new ELabel("秒");
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
