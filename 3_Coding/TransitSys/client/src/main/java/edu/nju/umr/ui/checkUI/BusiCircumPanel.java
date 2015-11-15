package edu.nju.umr.ui.checkUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JFrame;

import edu.nju.umr.ui.Constants;
/*
 * yyy
 * 20151029
 * 经营情况表
 */
public class BusiCircumPanel extends JPanel {

	private JTable statementTable;
	private JFrame frame;
	/**
	 * Create the panel.
	 */
	public BusiCircumPanel(JFrame fr) {
        setLayout(null);
        frame=fr;
		
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		
		JLabel start = new JLabel("开始日期");
		start.setBounds(Constants.TABLE_X, Constants.TABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(start);
		
		DatePanel startDate=new DatePanel();
		startDate.setBounds(Constants.TABLE_X+Constants.LABEL_WIDTH, Constants.TABLE_Y+4, 267, 21);
		add(startDate);
		
		JLabel end = new JLabel("结束日期");
		end.setBounds(Constants.TABLE_X, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(end);
		
		DatePanel endDate=new DatePanel();
		endDate.setBounds(Constants.TABLE_X+Constants.LABEL_WIDTH, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+4, 267, 21);
		add(endDate);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(Constants.PANEL_WIDTH/10*8, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+4, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(cancel);
		
		JButton confirm = new JButton("确认");
		confirm.setBounds(Constants.PANEL_WIDTH/10*7, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+4, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(confirm);
		
	    statementTable = new JTable();
		statementTable.setBounds(Constants.TABLE_X, Constants.LABEL_Y*3, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		add(statementTable);
		
		JLabel statementLabel = new JLabel("经营情况表");
		statementLabel.setFont(new Font("华文新魏",Font.PLAIN,15));
		statementLabel.setBounds(Constants.TABLE_X, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*2+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(statementLabel);
		
		JLabel nameLabel = new JLabel("经营情况表");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		JButton button = new JButton("退出");
		button.setBounds(Constants.PANEL_WIDTH/10*8, this.getHeight()/10*9, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(button);

	}

}
