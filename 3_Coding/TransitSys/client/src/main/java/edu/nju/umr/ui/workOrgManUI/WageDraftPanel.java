package edu.nju.umr.ui.workOrgManUI;

import javax.swing.JPanel;

import edu.nju.umr.ui.Constants;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;

public class WageDraftPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1937201346793974753L;
	private JTextField textFieldwm;
	private JTextField textFieldwc;
	private JTextField textFieldwi;
	private JTextField textFieldbound;
	private JFrame frame;

	/**
	 * Create the panel.
	 */
	public WageDraftPanel(JFrame fr) {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		frame=fr;
		
		JLabel nameLabel = new JLabel("薪水制定");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(nameLabel);
		
		//按月发薪
		
		JRadioButton rbMonth = new JRadioButton("按月发薪");
		rbMonth.setBounds(Constants.TABLE_X, Constants.TABLE_Y, 200, 23);
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
		
		JLabel wageMonth = new JLabel("月薪");
		wageMonth.setBounds(rbMonth.getX()+50, rbMonth.getY()+rbMonth.getHeight()+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(wageMonth);
		
		textFieldwm = new JTextField();
		textFieldwm.setBounds(wageMonth.getX()+wageMonth.getWidth(), wageMonth.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		textFieldwm.setEnabled(false);
		add(textFieldwm);
		textFieldwm.setColumns(10);
		
		//按次发薪
		
		JRadioButton rbCount = new JRadioButton("按次发薪");
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
		
		JLabel wageCount = new JLabel("次薪");
		wageCount.setBounds(wageMonth.getX(), rbCount.getY()+rbCount.getHeight()+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(wageCount);
		
		textFieldwc = new JTextField();
		textFieldwc.setBounds(textFieldwm.getX(), wageCount.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldwc);
		textFieldwc.setEnabled(false);
		textFieldwc.setColumns(10);
		
		//提成发薪
		
		JRadioButton rbBound = new JRadioButton("提成发薪");
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
		
		JLabel wageinit= new JLabel("月基本工资");
		wageinit.setBounds(wageMonth.getX(), rbBound.getY()+rbBound.getHeight()+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(wageinit);
		
		textFieldwi = new JTextField();
		textFieldwi.setBounds(textFieldwm.getX(), wageinit.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldwi);
		textFieldwi.setEnabled(false);
		textFieldwi.setColumns(10);
		
		JLabel bound = new JLabel("提成份额");
		bound.setBounds(wageMonth.getX(), wageinit.getY()+wageinit.getHeight()+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(bound);
		
		textFieldbound = new JTextField();
		textFieldbound.setBounds(textFieldwm.getX(), bound.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldbound);
		textFieldbound.setEnabled(false);
		textFieldbound.setColumns(10);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbBound);
		group.add(rbCount);
		group.add(rbMonth);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(this.getWidth()-300, bound.getY()+bound.getHeight()+20, 93, 23);
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancel);
		
		JButton confirm = new JButton("确认");
		confirm.setBounds(cancel.getX()-cancel.getWidth()-50, cancel.getY(), 93, 23);
		add(confirm);
	}
}
