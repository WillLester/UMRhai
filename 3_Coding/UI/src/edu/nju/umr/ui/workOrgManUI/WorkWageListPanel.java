package edu.nju.umr.ui.workOrgManUI;

import javax.swing.JPanel;

import edu.nju.umr.ui.Constants;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

public class WorkWageListPanel extends JPanel {
	private JTable listTable;
	private JTextField textFieldSearch;
	private JTextField textFieldwt;
	private JTextField textFieldwc;
	private JTextField textFieldwi;
	private JTextField textFieldBound;
	private JTextField textFieldwm;

	/**
	 * Create the panel.
	 */
	public WorkWageListPanel() {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		
		JLabel nameLabel = new JLabel("人员薪水信息列表");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN ,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH+60, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setText("请输入关键字");
		textFieldSearch.setBounds(Constants.TABLE_X,Constants.TABLE_Y, 300, 21);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton search = new JButton("搜索");
		search.setBounds(textFieldSearch.getX()+textFieldSearch.getWidth()+20,textFieldSearch.getY(), 90, 21);
		add(search);
		
		listTable = new JTable();
		listTable.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		add(listTable);
		
		JLabel wageType = new JLabel("计薪方式");
		wageType.setBounds(listTable.getX(), listTable.getY()+listTable.getHeight()+40, 54, 15);
		add(wageType);
		
		textFieldwt = new JTextField();
		textFieldwt.setBounds(wageType.getX()+wageType.getWidth()+10, wageType.getY(),90, 21);
		add(textFieldwt);
		textFieldwt.setColumns(10);
		
		JLabel wageMonth = new JLabel("月薪");
		wageMonth.setBounds(textFieldwt.getX()+textFieldwt.getWidth()+40, wageType.getY(), 54, 15);
		add(wageMonth);
		
		textFieldwm = new JTextField();
		textFieldwm.setBounds(wageMonth.getX()+wageMonth.getWidth()+10, wageMonth.getY(),90, 21);
		add(textFieldwm);
		textFieldwm.setColumns(10);
		
		JLabel wageCount = new JLabel("次薪");
		wageCount.setBounds(textFieldwm.getX()+textFieldwm.getWidth()+40, wageType.getY(), 54, 15);
		add(wageCount);
		
		textFieldwc = new JTextField();
		textFieldwc.setBounds(wageCount.getX()+wageCount.getWidth()+10, wageMonth.getY(),90, 21);
		add(textFieldwc);
		textFieldwc.setColumns(10);
		
		JLabel wageInit = new JLabel("基本工资");
		wageInit.setBounds(wageMonth.getX(), wageMonth.getY()+wageMonth.getHeight()+30, 54, 15);
		add(wageInit);
		
		
		
		textFieldwi = new JTextField();
		textFieldwi.setBounds(textFieldwm.getX(), wageInit.getY(),90, 21);
		add(textFieldwi);
		textFieldwi.setColumns(10);
		
		JLabel bound = new JLabel("提成份额");
		bound.setBounds(wageCount.getX(), wageInit.getY(), 54, 15);
		add(bound);
		
		textFieldBound = new JTextField();
		textFieldBound.setBounds(textFieldwc.getX(), wageInit.getY(), 90, 21);
		add(textFieldBound);
		textFieldBound.setColumns(10);
		
		
		
		JButton make = new JButton("制定薪水策略");
		make.setBounds(getWidth()-300, wageInit.getY(), 150, 23);
		add(make);
		
		JButton out = new JButton("退出");
		out.setBounds(make.getX(), make.getY()+make.getHeight()+30, 93, 23);
		add(out);
	}

}
