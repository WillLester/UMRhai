package edu.nju.umr.ui;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.constants.Province;
import edu.nju.umr.logic.cityLogic.LocLogic;
import edu.nju.umr.logicService.cityLogicSer.LocLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.LocVO;
import edu.nju.umr.vo.ResultMessage;

public class LocPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4716919307496599696L;
	private JTextField locField;
	private JComboBox<String> provinceCombo;
	private JComboBox<String> cityCombo;
	private JFrame frame;
	private ArrayList<LocVO> cities;
	private LocLSer logicSer;
	/**
	 * Create the panel.
	 */
	public LocPanel(JFrame fr) {
		setLayout(null);
		frame = fr;
		logicSer = new LocLogic();
		cities = new ArrayList<LocVO>();
		
		JLabel provinceLabel = new JLabel("省份");
		provinceLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		provinceLabel.setBounds(10, 10, 54, 22);
		add(provinceLabel);
		
		provinceCombo = new JComboBox<String>();
		provinceCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		provinceCombo.setBounds(62, 10, 74, 21);
		provinceCombo.setModel(new DefaultComboBoxModel<String>(Province.PROVINCES));
		provinceCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO 自动生成的方法存根
				if(arg0.getStateChange() == ItemEvent.SELECTED){
					setCities((String)provinceCombo.getSelectedItem());
				}
			}
		});
		add(provinceCombo);
		
		JLabel cityLabel = new JLabel("城市");
		cityLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		cityLabel.setBounds(146, 10, 54, 22);
		add(cityLabel);
		
		cityCombo = new JComboBox<String>();
		cityCombo.setBounds(193, 10, 75, 21);
		cityCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		add(cityCombo);
		
		JLabel locLabel = new JLabel("地址");
		locLabel.setHorizontalAlignment(SwingConstants.CENTER);
		locLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		locLabel.setBounds(271, 10, 62, 24);
		add(locLabel);
		
		locField = new JTextField();
		locField.setFont(new Font("宋体", Font.PLAIN, 20));
		locField.setColumns(10);
		locField.setBounds(341, 10, 165, 25);
		add(locField);

		initialize();
	}
	
	@SuppressWarnings("unchecked")
	private void initialize(){
		ResultMessage message = logicSer.getCities();
		if(message.getReInfo().equals(Result.SUCCESS)){
			cities = (ArrayList<LocVO>) message.getMessage();
			setCities("北京");
		} else {
			DoHint.hint(message.getReInfo(), frame);
		}
	}
	
	public String getProvince(){
		return (String) provinceCombo.getSelectedItem();
	}
	public String getCity(){
		return (String) cityCombo.getSelectedItem();
	}
	public String getLoc(){
		return locField.getText();
	}
	public void setProvince(String province){
		provinceCombo.setSelectedItem(province);
	}
	public void setCity(String city){
		cityCombo.setSelectedItem(city);
	}
	public void setLoc(String loc){
		locField.setText(loc);
	}
	public void setEnabled(boolean isEnabled){
		provinceCombo.setEnabled(isEnabled);
		cityCombo.setEnabled(isEnabled);
		locField.setEnabled(isEnabled);
	}
	public boolean isLegal(){
		if(locField.getText().equals("")){
			DoHint.hint("请输入地址！", frame);
			return false;
		}
		return true;
	}
	
	private void setCities(String province){
		ArrayList<String> cityName = new ArrayList<String>();
		for(LocVO loc:cities){
			if(loc.getProvince().equals(province)){
				cityName.add(loc.getCityName());
			}
		}
		String[] citiesPre = new String[cityName.size()];
		for(int i = 0;i < citiesPre.length;i++){
			citiesPre[i] = cityName.get(i);
		}
		cityCombo.setModel(new DefaultComboBoxModel<String>(citiesPre));
	}
}
