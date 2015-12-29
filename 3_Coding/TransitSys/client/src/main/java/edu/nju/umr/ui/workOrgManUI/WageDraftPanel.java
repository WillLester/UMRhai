package edu.nju.umr.ui.workOrgManUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Wage;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.ELabel;
import edu.nju.umr.ui.component.InfoPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.utility.DoHint;

public class WageDraftPanel extends InfoPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1937201346793974753L;
	private TextField textFieldwm;
	private TextField textFieldwc;
	private TextField textFieldwi;
	private TextField textFieldbound;
	private JRadioButton rbMonth;
	private JRadioButton rbCount;
	private JRadioButton rbBound;
	private JFrame frame;
	private WorkWageListPanel panel;
	private static final int y=30;
	/**
	 * Create the panel.
	 */
	public WageDraftPanel(JFrame fr,WorkWageListPanel pa) {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		frame=fr;
		panel = pa;
		
		JLabel nameLabel = new TitleLabel("薪水制定");
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2-50, 20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(nameLabel);
		
		//按月发薪
		
		rbMonth = new JRadioButton("按月发薪");
		rbMonth.setBackground(Color.WHITE);
		rbMonth.setBounds(Constants.TABLE_X, y+Constants.TABLE_Y, 200, 23);
		rbMonth.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					textFieldwm.setEnabled(true);
				} else {
					textFieldwm.setEnabled(false);
				}
			}
		});
		add(rbMonth);
		
		ELabel wageMonth = new ELabel("月薪");
		wageMonth.setBounds(rbMonth.getX()+50, rbMonth.getY()+rbMonth.getHeight()+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(wageMonth);
		
		textFieldwm = new TextField();
		textFieldwm.setBounds(wageMonth.getX()+wageMonth.getWidth(), wageMonth.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		textFieldwm.setEnabled(false);
		add(textFieldwm);
		textFieldwm.setColumns(10);
		
		//按次发薪
		
		rbCount = new JRadioButton("按次发薪");
		rbCount.setBackground(Color.WHITE);
		rbCount.setBounds(rbMonth.getX(), wageMonth.getY()+wageMonth.getHeight()+10,200, 23);
		rbCount.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					textFieldwc.setEnabled(true);
				} else {
					textFieldwc.setEnabled(false);
				}
			}
		});
		add(rbCount);
		
		ELabel wageCount = new ELabel("次薪");
		wageCount.setBounds(wageMonth.getX(), rbCount.getY()+rbCount.getHeight()+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(wageCount);
		
		textFieldwc = new TextField();
		textFieldwc.setBounds(textFieldwm.getX(), wageCount.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldwc);
		textFieldwc.setEnabled(false);
		textFieldwc.setColumns(10);
		
		//提成发薪
		
		rbBound = new JRadioButton("提成发薪");
		rbBound.setBackground(Color.WHITE);
		rbBound.setBounds(rbMonth.getX(), wageCount.getY()+wageCount.getHeight()+10,200, 23);
		rbBound.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					textFieldwi.setEnabled(true);
					textFieldbound.setEnabled(true);
				} else {
					textFieldwi.setEnabled(false);
					textFieldbound.setEnabled(false);
				}
			}
		});
		add(rbBound);
		
		ELabel wageinit= new ELabel("月基本工资");
		wageinit.setBounds(wageMonth.getX(), rbBound.getY()+rbBound.getHeight()+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(wageinit);
		
		textFieldwi = new TextField();
		textFieldwi.setBounds(textFieldwm.getX(), wageinit.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldwi);
		textFieldwi.setEnabled(false);
		textFieldwi.setColumns(10);
		
		ELabel bound = new ELabel("提成份额");
		bound.setBounds(wageMonth.getX(), wageinit.getY()+wageinit.getHeight()+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(bound);
		
		textFieldbound = new TextField();
		textFieldbound.setBounds(textFieldwm.getX(), bound.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldbound);
		textFieldbound.setEnabled(false);
		textFieldbound.setColumns(10);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbBound);
		group.add(rbCount);
		group.add(rbMonth);
		
		Button cancel = new CanButton();
		cancel.setBounds(this.getWidth()-300, bound.getY()+bound.getHeight()+20, 100, 30);
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancel);
		
		Button confirm = new ConfirmButton();
		confirm.setBounds(cancel.getX()-cancel.getWidth()-50, cancel.getY(), 100, 30);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					Result result;
					if(rbMonth.isSelected()){
						result = panel.setWage(Wage.MONTH, Integer.parseInt(textFieldwm.getText()), 0);
					} else if(rbCount.isSelected()){
						result = panel.setWage(Wage.TIME, Integer.parseInt(textFieldwc.getText()), 0);
					} else {
						result = panel.setWage(Wage.COMMISSION, Integer.parseInt(textFieldwi.getText()), Integer.parseInt(textFieldbound.getText()));
					}
					if(result.equals(Result.SUCCESS)){
						DoHint.hint(Result.SUCCESS, frame);
						try{
							Thread.sleep(300);
						}catch(Exception ex)
						{
							ex.printStackTrace();
						}
						frame.dispose();
					}
				}
			}
		});
		add(confirm);
	}
	private boolean isLegal(){
		if(rbMonth.isSelected()){
			try {
				int money = Integer.parseInt(textFieldwm.getText());
				if(money <= 0){
					DoHint.hint("金额必须为正数！", frame);
					return false;
				}
			} catch (NumberFormatException e) {
				DoHint.hint("金额应为整数！", frame);
				return false;
			}
		} else if(rbCount.isSelected()){
			try {
				int money = Integer.parseInt(textFieldwc.getText());
				if(money <= 0){
					DoHint.hint("金额必须为正数！", frame);
					return false;
				}
			} catch (NumberFormatException e) {
				DoHint.hint("金额应为整数！", frame);
				return false;
			}
		} else if(rbBound.isSelected()){
			try {
				int money = Integer.parseInt(textFieldwi.getText());
				if(money <= 0){
					DoHint.hint("金额必须为正数！", frame);
					return false;
				}
			} catch (NumberFormatException e) {
				DoHint.hint("金额应为整数！", frame);
				return false;
			}
			try {
				int commission = Integer.parseInt(textFieldbound.getText());
				if(commission <= 0){
					DoHint.hint("提成必须为正数！", frame);
					return false;
				}
				if(commission > 100){
					DoHint.hint("提成不能大于100！", frame);
					return false;
				}
			} catch (NumberFormatException e) {
				DoHint.hint("提成应为整数！", frame);
				return false;
			}
		} else{
			DoHint.hint("未选择薪水策略！", frame);
			return false;
		}
		return true;
	}
}
