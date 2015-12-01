package edu.nju.umr.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import edu.nju.umr.constants.Province;

public class LocPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4716919307496599696L;
	private JTextField locField;
	private JComboBox<String> provinceCombo;
	private JComboBox<String> cityCombo;
	/**
	 * Create the panel.
	 */
	public LocPanel() {
		setLayout(null);
		
		JLabel provinceLabel = new JLabel("省份");
		provinceLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		provinceLabel.setBounds(10, 10, 54, 22);
		add(provinceLabel);
		
		provinceCombo = new JComboBox<String>();
		provinceCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		provinceCombo.setBounds(62, 10, 74, 21);
		provinceCombo.setModel(new DefaultComboBoxModel<String>(Province.PROVINCES));
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
	public boolean isLegal(){
		return true;
	}
}
