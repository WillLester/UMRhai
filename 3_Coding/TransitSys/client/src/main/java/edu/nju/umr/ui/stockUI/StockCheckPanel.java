package edu.nju.umr.ui.stockUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import edu.nju.umr.ui.Constants;

public class StockCheckPanel extends JPanel{
	private JTable stockTable;
	private JFrame frame;
	/**
	 * Create the panel.
	 */
	public StockCheckPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		JLabel checkLabel = new JLabel("库存查看");
		checkLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		checkLabel.setBounds(503, 32, 97, 24);
		add(checkLabel);
		
		JLabel startLabel = new JLabel("开始时间");
		startLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		startLabel.setBounds(210, 71, 71, 24);
		add(startLabel);
		
		JComboBox yearCombo = new JComboBox();
		yearCombo.setBounds(285, 70, 71, 21);
		add(yearCombo);
		
		JLabel yearLabel = new JLabel("年");
		yearLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		yearLabel.setBounds(366, 71, 27, 19);
		add(yearLabel);
		
		JComboBox monthCombo = new JComboBox();
		monthCombo.setBounds(392, 70, 52, 21);
		add(monthCombo);
		
		JLabel monthLabel = new JLabel("月");
		monthLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		monthLabel.setBounds(458, 71, 27, 20);
		add(monthLabel);
		
		JComboBox dayCombo = new JComboBox();
		dayCombo.setBounds(484, 70, 52, 21);
		add(dayCombo);
		
		JLabel dayLabel = new JLabel("日");
		dayLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		dayLabel.setBounds(546, 71, 27, 19);
		add(dayLabel);
		
		JComboBox hourCombo = new JComboBox();
		hourCombo.setBounds(572, 70, 52, 21);
		add(hourCombo);
		
		JLabel hourLabel = new JLabel("时");
		hourLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		hourLabel.setBounds(636, 71, 27, 19);
		add(hourLabel);
		
		JComboBox minCombo = new JComboBox();
		minCombo.setBounds(662, 70, 54, 21);
		add(minCombo);
		
		JLabel minLabel = new JLabel("分");
		minLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		minLabel.setBounds(726, 71, 27, 19);
		add(minLabel);
		
		JComboBox secCombo = new JComboBox();
		secCombo.setBounds(752, 70, 54, 21);
		add(secCombo);
		
		JLabel secLabel = new JLabel("秒");
		secLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		secLabel.setBounds(816, 71, 27, 19);
		add(secLabel);
		
		JLabel endLabel = new JLabel("结束时间");
		endLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		endLabel.setBounds(210, 116, 71, 19);
		add(endLabel);
		
		JComboBox endYCombo = new JComboBox();
		endYCombo.setBounds(285, 115, 71, 21);
		add(endYCombo);
		
		JLabel endYLabel = new JLabel("年");
		endYLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		endYLabel.setBounds(366, 116, 27, 19);
		add(endYLabel);
		
		JComboBox endMCombo = new JComboBox();
		endMCombo.setBounds(392, 115, 52, 21);
		add(endMCombo);
		
		JLabel endMLabel = new JLabel("月");
		endMLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		endMLabel.setBounds(458, 116, 27, 20);
		add(endMLabel);
		
		JComboBox endDCombo = new JComboBox();
		endDCombo.setBounds(484, 115, 52, 21);
		add(endDCombo);
		
		JLabel endDLabel = new JLabel("日");
		endDLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		endDLabel.setBounds(546, 116, 27, 19);
		add(endDLabel);
		
		JComboBox endHCombo = new JComboBox();
		endHCombo.setBounds(572, 115, 52, 21);
		add(endHCombo);
		
		JComboBox endMiCombo = new JComboBox();
		endMiCombo.setBounds(662, 115, 54, 21);
		add(endMiCombo);
		
		JComboBox endSCombo = new JComboBox();
		endSCombo.setBounds(752, 115, 54, 21);
		add(endSCombo);
		
		JLabel endHLabel = new JLabel("时");
		endHLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		endHLabel.setBounds(636, 116, 27, 19);
		add(endHLabel);
		
		JLabel endMiLabel = new JLabel("分");
		endMiLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		endMiLabel.setBounds(726, 116, 27, 19);
		add(endMiLabel);
		
		JLabel endSLabel = new JLabel("秒");
		endSLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		endSLabel.setBounds(816, 118, 27, 19);
		add(endSLabel);
		
		stockTable = new JTable();
		stockTable.setBounds(219, 156, 665, 372);
		add(stockTable);
		
		JButton exitButton = new JButton("退出查看");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(816, 550, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
			}
		});
		add(exitButton);

	}
}
