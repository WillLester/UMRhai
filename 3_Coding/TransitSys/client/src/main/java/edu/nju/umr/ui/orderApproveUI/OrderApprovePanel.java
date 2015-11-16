package edu.nju.umr.ui.orderApproveUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.nju.umr.ui.Constants;

public class OrderApprovePanel extends JPanel{
	private JTable orderList;
	private JFrame frame;

	/**
	 * Create the panel.
	 */
	public OrderApprovePanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		JLabel approveLabel = new JLabel("审批单据");
		approveLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		approveLabel.setBounds(505, 40, 93, 24);
		add(approveLabel);
		
		orderList = new JTable();
		orderList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		orderList.setBounds(193, 71, 717, 421);
		add(orderList);
		
		JButton allButton = new JButton("全选");
		allButton.setFont(new Font("宋体", Font.PLAIN, 12));
		allButton.setBounds(927, 103, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(allButton);
		
		JButton passedButton = new JButton("通过审批");
		passedButton.setFont(new Font("宋体", Font.PLAIN, 12));
		passedButton.setBounds(927, 159, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(passedButton);
		
		JButton unpassedButton = new JButton("不通过审批");
		unpassedButton.setFont(new Font("宋体", Font.PLAIN, 12));
		unpassedButton.setBounds(927, 215, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(unpassedButton);
		
		JButton checkButton = new JButton("查看详细");
		checkButton.setFont(new Font("宋体", Font.PLAIN, 12));
		checkButton.setBounds(927, 271, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(checkButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(927, 327, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(exitButton);

	}
}
